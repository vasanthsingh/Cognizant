console.log("Welcome to the Community Portal");

window.addEventListener("load", function () {
  alert("The Community Portal is fully loaded.");
});

class EventItem {
  constructor(name, date, category, location, seats) {
    this.name = name;
    this.date = date;
    this.category = category;
    this.location = location;
    this.seats = seats;
  }
}

EventItem.prototype.checkAvailability = function () {
  return new Date(this.date) >= new Date() && this.seats > 0;
};

const communityEvents = [];
const categoryCounters = {};

const eventList = document.querySelector("#eventList");
const emptyMessage = document.querySelector("#emptyMessage");
const categoryFilter = document.querySelector("#categoryFilter");
const locationFilter = document.querySelector("#locationFilter");
const searchBox = document.querySelector("#searchBox");
const registrationForm = document.querySelector("#registrationForm");
const registrationMessage = document.querySelector("#registrationMessage");
const summaryBox = document.querySelector("#summaryBox");
const loadingText = document.querySelector("#loadingText");
const selectedEvent = document.querySelector("#selectedEvent");

let cardsHidden = false;

function createCategoryCounter(category) {
  let totalRegistrations = 0;
  return function () {
    totalRegistrations += 1;
    categoryCounters[category] = totalRegistrations;
    return totalRegistrations;
  };
}

function seedEvents() {
  const eventName = "Community Music Night";
  const eventDate = "2026-12-10";
  let seats = 20;
  communityEvents.push(new EventItem(eventName, eventDate, "music", "Town Hall", seats));

  const workshopName = "Workshop on Baking";
  const workshopDate = "2026-11-02";
  let workshopSeats = 12;
  communityEvents.push(new EventItem(workshopName, workshopDate, "workshop", "Library", workshopSeats));

  const sportsName = "Local Sports Meet";
  const sportsDate = "2026-08-22";
  let sportsSeats = 8;
  communityEvents.push(new EventItem(sportsName, sportsDate, "sports", "Playground", sportsSeats));

  const charityName = "Charity Drive";
  const charityDate = "2025-04-15";
  let charitySeats = 0;
  communityEvents.push(new EventItem(charityName, charityDate, "charity", "Community Center", charitySeats));
}

seedEvents();

function populateRegistrationOptions() {
  if (!selectedEvent) {
    return;
  }

  const availableEvents = communityEvents.filter(function (event) {
    return event.checkAvailability();
  });

  selectedEvent.innerHTML = '<option value="">Choose an event</option>';

  availableEvents.forEach(function (event) {
    const option = document.createElement("option");
    option.value = event.name;
    option.textContent = `${event.name} - ${event.location}`;
    selectedEvent.appendChild(option);
  });
}

function filterEventsByCategory(events, category, callback = function (event, selectedCategory) {
  if (selectedCategory === "all") {
    return true;
  }
  return event.category === selectedCategory;
}) {
  const clonedList = [...events];
  return clonedList.filter(function (event) {
    return callback(event, category);
  });
}

function addEvent(eventData) {
  const newEvent = new EventItem(
    eventData.name,
    eventData.date,
    eventData.category,
    eventData.location,
    eventData.seats
  );
  communityEvents.push(newEvent);
  populateRegistrationOptions();
  renderEvents();
}

function registerUser(eventName) {
  try {
    const event = communityEvents.find(function (item) {
      return item.name === eventName;
    });

    if (!event) {
      throw new Error("Event not found.");
    }

    if (!event.checkAvailability()) {
      throw new Error("This event is full or already past.");
    }

    event.seats--;

    const counter = categoryCounters[event.category] || createCategoryCounter(event.category);
    const total = counter();
    summaryBox.textContent = `${event.category} registrations: ${total}`;

    renderEvents();
  } catch (error) {
    alert(error.message);
  }
}

function cancelRegistration(eventName) {
  const event = communityEvents.find(function (item) {
    return item.name === eventName;
  });

  if (event) {
    event.seats++;
    populateRegistrationOptions();
    renderEvents();
  }
}

function createEventCard(event) {
  const card = document.createElement("div");
  card.className = "card";

  const availabilityText = event.checkAvailability() ? "Upcoming and open" : "Past or full";
  const infoRows = Object.entries(event)
    .map(function (entry) {
      return `<p class="muted"><strong>${entry[0]}:</strong> ${entry[1]}</p>`;
    })
    .join("");

  card.innerHTML = `
    <h3>${event.name}</h3>
    <p>${event.date}</p>
    <p>${event.location}</p>
    <p>${event.category}</p>
    <p class="status">${availabilityText}</p>
    <p>Seats left: ${event.seats}</p>
    ${infoRows}
  `;

  const registerButton = document.createElement("button");
  registerButton.textContent = "Register";
  registerButton.onclick = function () {
    registerUser(event.name);
  };

  const cancelButton = document.createElement("button");
  cancelButton.textContent = "Cancel";
  cancelButton.className = "secondary";
  cancelButton.onclick = function () {
    cancelRegistration(event.name);
  };

  card.appendChild(registerButton);
  card.appendChild(cancelButton);

  return card;
}

function renderEvents(customList) {
  eventList.innerHTML = "";

  const selectedCategory = categoryFilter.value;
  const selectedLocation = locationFilter.value.toLowerCase();
  const searchText = searchBox.value.toLowerCase();

  const filteredByCategory = filterEventsByCategory(customList || communityEvents, selectedCategory, function (event, category) {
    if (category === "all") {
      return true;
    }
    return event.category === category;
  });

  const filteredEvents = filteredByCategory.filter(function (event) {
    const matchesLocation = selectedLocation === "" || event.location.toLowerCase().includes(selectedLocation);
    const matchesSearch = searchText === "" || event.name.toLowerCase().includes(searchText);

    if (event.checkAvailability() && event.seats > 0) {
      return matchesLocation && matchesSearch;
    }

    return false;
  });

  if (filteredEvents.length === 0) {
    emptyMessage.classList.remove("hidden");
  } else {
    emptyMessage.classList.add("hidden");
  }

  filteredEvents.forEach(function (event) {
    eventList.appendChild(createEventCard(event));
  });

  if (window.jQuery) {
    window.jQuery("#eventList .card").hide().fadeIn(200);
  }
}

function clearRegistrationErrors() {
  document.querySelector("#fullNameError").textContent = "";
  document.querySelector("#emailAddressError").textContent = "";
  document.querySelector("#selectedEventError").textContent = "";
}

function showRegistrationError(fieldId, message) {
  document.querySelector(fieldId).textContent = message;
}

function postRegistrationToServer(payload) {
  return new Promise(function (resolve, reject) {
    setTimeout(function () {
      fetch("https://jsonplaceholder.typicode.com/posts", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(payload)
      })
        .then(function (response) {
          if (!response.ok) {
            throw new Error("Mock API request failed.");
          }
          return response.json();
        })
        .then(function (data) {
          resolve(data);
        })
        .catch(function (error) {
          reject(error);
        });
    }, 1200);
  });
}

async function handleRegistration(event) {
  event.preventDefault();
  console.log("Registration step 1: form submit prevented");

  clearRegistrationErrors();
  registrationMessage.textContent = "";
  registrationMessage.className = "message-box muted";

  const form = registrationForm;
  const elements = form.elements;
  const name = elements.fullName.value.trim();
  const email = elements.emailAddress.value.trim();
  const eventName = elements.selectedEvent.value;

  console.log("Registration step 2: captured values", { name: name, email: email, eventName: eventName });

  let hasError = false;

  if (name === "") {
    showRegistrationError("#fullNameError", "Name is required.");
    hasError = true;
  }

  if (email === "" || !email.includes("@")) {
    showRegistrationError("#emailAddressError", "Enter a valid email.");
    hasError = true;
  }

  if (eventName === "") {
    showRegistrationError("#selectedEventError", "Choose an event.");
    hasError = true;
  }

  if (hasError) {
    console.log("Registration step 3: validation failed");
    registrationMessage.textContent = "Please fix the errors above.";
    registrationMessage.classList.remove("success-text");
    return;
  }

  const payload = {
    name: name,
    email: email,
    selectedEvent: eventName
  };

  console.log("Registration step 4: sending POST payload", payload);
  registrationMessage.textContent = "Sending registration...";

  try {
    const response = await postRegistrationToServer(payload);
    const registeredEvent = communityEvents.find(function (item) {
      return item.name === eventName;
    });

    if (registeredEvent) {
      registeredEvent.seats--;
      populateRegistrationOptions();
      renderEvents();
    }

    console.log("Registration step 5: response received", response);
    registrationMessage.textContent = `Success: ${name} registered for ${eventName}.`;
    registrationMessage.classList.add("success-text");
  } catch (error) {
    console.log("Registration step 5: request failed", error);
    registrationMessage.textContent = "Registration failed. Try again later.";
    registrationMessage.classList.remove("success-text");
  }
}

function toggleCardsWithJQuery() {
  if (!window.jQuery) {
    return;
  }

  const cards = window.jQuery("#eventList .card");

  if (cardsHidden) {
    cards.fadeIn(200);
  } else {
    cards.fadeOut(200);
  }

  cardsHidden = !cardsHidden;
}

function loadMockEventsWithPromise() {
  loadingText.classList.remove("hidden");

  fetch("mock-events.json")
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {
      data.forEach(function (item) {
        communityEvents.push(new EventItem(item.name, item.date, item.category, item.location, item.seats));
      });
      populateRegistrationOptions();
      renderEvents();
    })
    .catch(function () {
      alert("Mock JSON could not be loaded, so the local sample list will stay in use.");
    })
    .finally(function () {
      loadingText.classList.add("hidden");
    });
}

async function loadMockEventsWithAsync() {
  loadingText.classList.remove("hidden");

  try {
    const response = await fetch("mock-events.json");
    const data = await response.json();

    data.forEach(function (item) {
      communityEvents.push(new EventItem(item.name, item.date, item.category, item.location, item.seats));
    });

    populateRegistrationOptions();
    renderEvents();
  } catch (error) {
    alert("Async load failed, using the current local events instead.");
  } finally {
    loadingText.classList.add("hidden");
  }
}

document.querySelector("#addEventBtn").onclick = function () {
  const name = document.querySelector("#eventName").value;
  const date = document.querySelector("#eventDate").value;
  const category = document.querySelector("#eventCategory").value;
  const location = document.querySelector("#eventLocation").value;
  const seats = Number(document.querySelector("#eventSeats").value);

  if (!name || !date || !category || !location || !seats) {
    alert("Please fill in all event fields.");
    return;
  }

  addEvent({ name: name, date: date, category: category, location: location, seats: seats });
};

if (registrationForm) {
  registrationForm.addEventListener("submit", handleRegistration);
}

if (window.jQuery) {
  window.jQuery("#registerBtn").click(function (event) {
    console.log("jQuery click: register button pressed");
    handleRegistration(event);
  });

  window.jQuery("#toggleCardsBtn").click(function () {
    toggleCardsWithJQuery();
  });
}

document.querySelector("#loadPromiseBtn").onclick = function () {
  loadMockEventsWithPromise();
};

document.querySelector("#loadAsyncBtn").onclick = function () {
  loadMockEventsWithAsync();
};

document.querySelector("#showMusicBtn").onclick = function () {
  const musicEvents = communityEvents.filter(function (event) {
    return event.category === "music";
  });
  renderEvents(musicEvents);
};

categoryFilter.onchange = function () {
  renderEvents();
};

locationFilter.onchange = function () {
  renderEvents();
};

searchBox.onkeydown = function () {
  renderEvents();
};

populateRegistrationOptions();
renderEvents();