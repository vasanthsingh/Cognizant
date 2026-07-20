import React, { useState } from 'react';

function Counter() {
const [count, setCount] = useState(0);

const handleIncrement = () => setCount(prevCount => prevCount + 1);

const handleDecrement = () => setCount(prevCount => prevCount - 1);

const handleAlert = () => alert("Welcome!");

const handleClick = () => alert("I was Clicked!");
return (
<div>
<h2>Count: {count}</h2>
<button onClick={handleIncrement}>Increment</button>
<button onClick={handleDecrement}>Decrement</button>
<button onClick={handleAlert}>Say Welcome</button>
<button onClick={handleClick}>Click here</button>
</div>
);
}

export default Counter;