
## 1. Various Ways of Conditional Rendering

**Conditional rendering** in React allows you to display different components or elements based on certain conditions.

### Methods:
- **If/Else Statements**: Use regular JavaScript if/else logic before the return statement.
- **Ternary Operator**: `condition ? <ComponentA /> : <ComponentB />`
- **Logical AND (&&)**: `condition && <Component />` - renders component only if condition is true.
- **Logical OR (||)**: `condition || <DefaultComponent />` - renders default if condition is false.
- **Switch Statements**: For handling multiple distinct conditions.
- **Immediately Invoked Function Expressions (IIFE)**: `{(() => { /* logic */ })()}`

### Examples:

```jsx
// Ternary operator example
{isLoggedIn ? <Dashboard /> : <Login />}

// Logical AND example
{showMessage && <div>Welcome!</div>}
```

## 2. How to Render Multiple Components

**Multiple components** can be rendered together in React using several approaches without adding extra nodes to the DOM.

### Methods:
- **React Fragments**: `<React.Fragment>` or the `<>` shorthand to wrap multiple elements.
- **Array of Components**: Return an array of JSX elements, ensuring each has a `key`.
- **Parent Container**: Wrap elements in a single `<div>` or other HTML element if a wrapper is needed for styling.

### Examples:

```jsx
// Using a Fragment
return (
  <>
    <Header />
    <Main />
    <Footer />
  </>
);

// Using an array
return [
  <Header key="header" />,
  <Main key="main" />,
  <Footer key="footer" />
];
```

## 3. List Component Definition

A list component is a React component designed to render a collection of similar items dynamically from a data source.

### Key Characteristics:
- Iterates over an array of data (e.g., using the map() function).
- Renders each item using a consistent component structure.
- Requires a unique key prop for each item in the list for efficient updates.
- Handles dynamic data sources efficiently.

### Example:

```jsx
function ItemList({ items }) {
  return (
    <ul>
      {items.map(item => (
        <li key={item.id}>{item.name}</li>
      ))}
    </ul>
  );
}
```

## 4. Keys in React Applications

Keys are special string attributes you need to include when creating lists of elements. They help React identify which items have changed, are added, or are removed.

### Purpose:
- **Optimize Rendering**: Keys give elements a stable identity, allowing React to optimize performance by avoiding unnecessary re-renders.
- **Prevent Bugs**: They help maintain component state correctly when a list is re-ordered, filtered, or items are added/deleted.
- **Ensure DOM Stability**: Proper keys ensure that the correct DOM elements are updated during reconciliation.

### Best Practices:
- Use Stable & Unique IDs: Use a unique and stable identifier from your data, like a database ID (item.id).
- Avoid Array Indices: Do not use array indices as keys if the list order can change, as this can lead to performance issues and bugs with component state.
- Keep Keys Consistent: Keys should be consistent between renders for the same item.

### Examples:

```jsx
// Good: Using a stable ID from the data
{users.map(user => <User key={user.id} data={user} />)}

// Bad: Using an array index when the list order can change
{users.map((user, index) => <User key={index} data={user} />)}
```

## 5. How to Extract Components with Keys

Extracting components with keys is the practice of creating a separate component for list items to improve readability and reusability, while correctly managing the key prop.

### Steps:
1. Identify the repetitive JSX pattern inside your map() loop.
2. Create a new, separate component for that repetitive element (e.g., TodoItem).
3. Pass the key prop to the top-level element of the new component within the map() loop.
4. Pass other necessary data as props to the new component.

### Example:

```jsx
// --- Before Extraction ---
function TodoList({ todos }) {
  return (
    <ul>
      {todos.map(todo => (
        <li key={todo.id}>
          <span>{todo.text}</span>
          <button>Delete</button>
        </li>
      ))}
    </ul>
  );
}

function TodoItem({ todo }) {
  return (
    <li>
      <span>{todo.text}</span>
      <button>Delete</button>
    </li>
  );
}
function TodoList({ todos }) {
  return (
    <ul>
      {todos.map(todo => (
        // The key is applied here, on the component instance
        <TodoItem key={todo.id} todo={todo} />
      ))}
    </ul>
  );
}
```

## 6. React Map and map() Function

The map() function in JavaScript is the standard way to transform an array of data into an array of JSX components in React.

### map() Function Features:
- Transforms each element of an array based on a callback function.
- Returns a new array containing the results, without modifying the original array.
- The callback function receives the current element, index, and the original array as arguments.

### Usage in React:
- **Render Dynamic Lists**: Convert an array of data into a list of components.
- **Data Transformation**: Transform data structures on the fly while rendering.
- **Combine with other methods**: Chain map() with filter() or sort() to render filtered or sorted lists.

### Examples:

```jsx
// Basic map usage
const numbers = [1, 2, 3, 4, 5];
const listItems = numbers.map(number => 
  <li key={number.toString()}>{number}</li>
);

// Complex data mapping
const products = [
  { id: 'p1', name: 'Phone', price: 999 },
  { id: 'p2', name: 'Laptop', price: 1299 }
];

const ProductList = () => (
  <div>
    {products.map(product => (
      <div key={product.id}>
        <h3>{product.name}</h3>
        <p>${product.price}</p>
      </div>
    ))}
  </div>
);
```
