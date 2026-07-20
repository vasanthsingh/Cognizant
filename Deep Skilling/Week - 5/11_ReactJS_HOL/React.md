
## 1. Explain React Events

**React events** are the system by which user interactions (such as clicks, keystrokes, form submissions, etc.) can be detected and responded to in React applications. While inspired by browser DOM events, React implements its own event system for better performance and cross-browser compatibility.

- React events are wrapped in the React event system, making them consistent across browsers.
- Events are attached to components using special properties (like `onClick`, `onChange`).
- React batches event handling for performance.

**Example:**
```<button onClick={handleClick}>Click Me</button>```


---

## 2. Explain About Event Handlers

**Event handlers** are functions that execute in response to a user’s interaction with a component (like clicking a button or typing into an input). In React, these handlers are attached as props following specific naming conventions and receive a synthetic event object as an argument.

- Event handlers can be class methods or inline functions.
- They receive a synthetic event argument, which is similar to a browser’s event object.
- You must use braces `{}` to pass a function reference, *not* a string.

**Example:**
```function handleClick(event) {
alert('Button was clicked!');
}

<button onClick={handleClick}>Click Me</button>
```

---

## 3. Define Synthetic Event

A **Synthetic Event** is React’s cross-browser wrapper around the native browser event. React creates a SyntheticEvent to standardize events across different browsers, making it easier to write code that works everywhere.

- SyntheticEvent has the same interface as native events (like `event.target`, `event.type`).
- It is pooled for performance reasons—after the event handler has run, its properties may become null.
- To access event values asynchronously, use `event.persist()`.

**Example:**
```function handleInput(event) {
console.log(event.target.value); // SyntheticEvent in React
}
<input onChange={handleInput} />
```


---

## 4. Identify React Event Naming Convention

React follows these naming conventions for events:

- Event handler props use **camelCase** notation (e.g., `onClick`, `onChange`, `onMouseEnter`) rather than lowercase (as used in HTML).
- Handler function names are typically camelCase as well (e.g., `handleClick`, `onSubmit`).
- The value of the event prop should be a function reference (not a string).

**Examples:**
```<button onClick={handleClick}>Click</button> // Correct (camelCase, function)
<button onclick="handleClick()">Click</button> // Incorrect (lowercase, string)
```

