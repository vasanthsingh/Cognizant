
## 1. Define JSX

**JSX (JavaScript XML)** is a syntax extension for JavaScript, most often used with React to describe what the UI should look like. JSX allows you to write HTML-like markup directly in your JavaScript code, making it easier to visualize and manage user interfaces in React applications. After compilation (typically using Babel), JSX code is transformed into regular JavaScript function calls, becoming objects that represent UI elements[1][2][4][5][12].

**Example:**
```const element = <h1>Hello, world!</h1>;```

JSX is not required in React, but it is highly recommended due to its readability and convenience[12].

---

## 2. Explain about ECMA Script

**ECMA Script** (often abbreviated as **ES**) is the standardized scripting language specification that JavaScript implements[6][13]. Defined by Ecma International (ECMA-262), ECMAScript lays out the core features that JavaScript engines must provide, ensuring compatibility across browsers and environments. ECMAScript includes features such as block scope (let, const), default parameters, classes, modules, promises, and more, supporting functional and object-oriented programming styles.

- **Purpose:** Defines how scripting languages like JavaScript should work, creating interoperability across platforms.
- **Major versions:** ES5 (2009), ES6/ES2015 (significant update), and ongoing yearly updates[6][13].

---

## 3. Explain React.createElement()

The `React.createElement()` method is a core React API, used internally to create React elements (the building blocks of React apps). JSX you write is eventually compiled into `React.createElement()` function calls.

**Syntax:**
React.createElement(type, props, ...children)

- **type:** String (for HTML tags) or a React component.
- **props:** Object with attributes, event handlers, etc.
- **children:** Child elements or content.

**Example (JSX and its compiled form):**

This function returns a plain JS object describing the element to be rendered. React uses it to manage and update the DOM efficiently.

---

## 4. Explain How to Create React Nodes with JSX

To create React nodes with JSX, simply write HTML-like tags inside your JavaScript file. These tags represent elements that React will render.

**Example:**
```const names = ["Alice", "Bob", "Charlie"];
return (

<div> {names.map(name => <div key={name}>{name}</div>)} </div> );
```
 - Wrap dynamic content (like JavaScript expressions) in curly braces `{}`. - When rendering lists, React requires a unique `key` prop for each child for efficient updates[8].

## 5. Define How to Render JSX to DOM
To render JSX to the DOM, use the ReactDOM.createRoot() and root.render() methods. All React elements must be rendered within a root DOM node.

**Example:**
```<!-- In your HTML file -->
<div id="root"></div>
// In your JS/React file
import React from 'react';
import ReactDOM from 'react-dom/client';

const element = <h1>Hello, world!</h1>;
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(element);
```
This displays the JSX on the actual web page.

## 6. Explain How to Use JavaScript Expressions in JSX
JavaScript expressions can be embedded inside JSX using curly braces {}. These expressions can evaluate to any value—strings, numbers, function calls, or variables.

**Example:**
```const user = { firstName: "Jane", lastName: "Doe" };
const greeting = <h1>Hello, {user.firstName}!</h1>;
```
7. Explain How to Use Inline CSS in JSX
Inline CSS in JSX is done by assigning a JavaScript object to the style attribute of a JSX element. CSS property names must be written in camelCase (e.g., backgroundColor instead of background-color).

**Example:**
```const styleObj = { color: "red", fontSize: "18px" };

function MyComponent() {
  return <h2 style={styleObj}>Styled Text</h2>;
}```
