export default function IndianPlayers({T20, ranji}) {
    const players = [...T20, ...ranji];
    return(
        <div>
            <ul>
                {players.map((player, index) => (
                    <li key={index}>
                        {player.name} - Score: {player.score}
                    </li>
                ))}
            </ul>
        </div>
    )
}