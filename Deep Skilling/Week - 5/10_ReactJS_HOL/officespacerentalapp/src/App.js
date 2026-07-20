
import './App.css';

const offices = [
  {
    id: 1,
    name: "Downtown Workspace",
    rent: 45000,
    address: "123 Market St, City Center",
    img: "https://s3.mortarr.com/images/project_gallery_images/open-concept-office-space-designs.jpeg",
  },
  {
    id: 2,
    name: "Uptown Executive Suite",
    rent: 75000,
    address: "809 Corporate Plaza, Uptown",
    img: "https://psnltd.com/wp-content/uploads/2022/12/iStock-1352854006.jpg",
  },
  {
    id: 3,
    name: "Suburban Office Park",
    rent: 59000,
    address: "400 Suburbia Dr, Suburban",
    img: "https://images.unsplash.com/photo-1460518451285-97b6aa326961?auto=format&fit=crop&w=400&q=80",
  }
];

const rentColor = (rent) => (rent < 60000 ? 'red' : 'green');

function App() {
  return (
    <div style={{maxWidth:"800px", margin:"auto"}}>
      <h1>Office Space Rental App</h1>
      
      <div>
        {offices.map((office) => (
          <div
            key={office.id}
            className="office-card"
            style={{
              border: "1px solid #ccc",
              borderRadius: "8px",
              padding: "16px",
              marginBottom: "18px",
              display: "flex",
              alignItems: "center"
            }}
          >
            <img 
              src={office.img}
              alt={office.name}
              style={{width: "120px", height: "80px", objectFit: "cover", marginRight: "16px", borderRadius: "6px"}}
            />
            
            <div>
              <h2>{office.name}</h2>
              <p>
                <b>Rent:</b>{" "}
                <span style={{color: rentColor(office.rent)}}>
                  ₹{office.rent}
                </span>
              </p>
              <p>
                <b>Address:</b> {office.address}
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
