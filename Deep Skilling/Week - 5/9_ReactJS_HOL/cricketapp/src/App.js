
import './App.css';
import ListofPlayer from './ListofPlayer';
import OddPlayers from './Oddplayers';
import ScoreBelow70 from './ScoreBelow70';
import IndianPlayers from './IndianPlayers';
import EvenPlayers from './evenplayers';

const batch=["honey","pearl","sugar","candy","chocolate"];

const players = [
  { name: "Rohit", score: 54 },
  { name: "Shikhar", score: 68 },
  { name: "Virat", score: 102 },
  { name: "Suryakumar", score: 78 },
  { name: "Hardik", score: 44 },
  { name: "Rishabh", score: 32 },
  { name: "Jadeja", score: 26 },
  { name: "Bhuvneshwar", score: 19 },
  { name: "Shami", score: 5 },
  { name: "Bumrah", score: 12 },
  { name: "Kuldeep", score: 21 }
];

const T20 = [
  { name: "Rohit", score: 54 },
  { name: "Shikhar", score: 68 },
  { name: "Virat", score: 102 }
];

const ranji = [
  { name: "Suryakumar", score: 78 },
  { name: "Hardik", score: 44 },
  { name: "Rishabh", score: 32 },
  { name: "Jadeja", score: 26 },
];

var flag =false;
function App() {
  if (flag===true) {
    return(
      <div>
        <h1>List of Players</h1>
        <ListofPlayer players={players}/>
        <hr/>
        <h1>Players with Scores Below 70</h1>
        <ScoreBelow70 players={players}/>
        </div>
      
    )
  }
  else {
    return(
      <div>
        <h1>Odd Players</h1>
        <OddPlayers players={players}/>
        <hr/>
        <h1>Even Players</h1>
        <EvenPlayers players={players}/>
        <hr/>

        <h1>Indian Players</h1>
        <IndianPlayers T20={T20} ranji={ranji}/>
      </div>
    )
  }
}

export default App;
