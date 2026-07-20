export default function evenPlayers({players}) {
    const [,second,, fourth,, sixth,, eighth,, tenth] = players;
    return(
        <div>   
            <ul>
            <li>Second:  {second.name}</li>
            <li>Fourth:  {fourth.name}</li>
            <li>Sixth:  {sixth.name}</li>
            <li>Eighth:  {eighth.name}</li>
            <li>Tenth:  {tenth.name}</li>
            </ul>
        </div>
    )
}