# React Components Overview

## 1. Explain React Components

**React components** are the core building blocks of React applications. Each component represents a part of the user interface (UI), encapsulating its own structure, logic, and style. Components can be **reused, composed, and nested**, making it easy to build complex interfaces from small, manageable pieces.

- Components isolate their implementation, allowing independent development and testing.
- They can manage their own state and accept input as props.
- React re-renders components efficiently when their data changes.

## 2. Identify the Differences Between Components and JavaScript Functions

| Aspect               | React Component                                 | JavaScript Function                        |
|----------------------|------------------------------------------------|--------------------------------------------|
| Purpose              | Manages UI, state, and lifecycle in React      | Executes logic or returns data             |
| Return Value         | Returns JSX (UI markup for rendering)          | Returns any value (number, string, object) |
| Lifecycle Methods    | Supports React lifecycle methods/hook use      | No lifecycle management                    |
| State Management     | Can manage state (state/hooks)                 | No built-in state, unless externally managed|
| Usage in UI          | Built to be used as part of UI structure       | General-purpose code                       |

*React components* are specifically integrated with the React rendering engine, while JavaScript functions are general code constructs used for logic and computations.

## 3. Identify the Types of Components

**There are two main types of React components:**

- **Class Components**
  - Defined using ES6 `class` syntax.
  - Support state management and React lifecycle methods.
- **Function Components**
  - Defined as JavaScript functions.
  - Simpler, use React Hooks (like `useState`, `useEffect`) for state and side effects.

## 4. Explain Class Component

A **class component** is a React component created using a JavaScript `class` that extends `React.Component`. It can maintain its own state and manage lifecycle events.

**Key characteristics:**
- Has a `constructor` for initializing state and binding methods.
- Requires a `render()` method, which returns JSX.
- Can access lifecycle methods like `componentDidMount`.


## 5. Explain Function Component

A **function component** is a plain JavaScript function that receives `props` and returns JSX. With the introduction of React Hooks, function components can now handle state and side effects.

**Key characteristics:**
- Simpler to write and understand.
- Use hooks like `useState` to manage state.


## 6. Define Component Constructor

A **component constructor** is a special method in class components used to initialize state and bind event handlers. It runs once when the component is created.

- Must call `super(props)` before accessing `this`.
- Allows initial setup of local state.


## 7. Define render() Function

The **render() function** is a mandatory method in class components. It returns the React elements (JSX) to be rendered on the UI.

- Called whenever `props` or `state` change.
- Must return a single parent element.

