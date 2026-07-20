

function ScoreBelow70({players}) {
    let player70 = [];
    {players.map((item) => {
        if (item.score < 70) {
            player70.push(item);
    }})}
    return (
    <div>
      <ul>
        {player70.map((player,index) => (
          <li key={index}>
            Mr. {player.name} - Score: {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
}  

export default ScoreBelow70;