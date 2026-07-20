
## 1. Conditional Rendering in React

Conditional rendering in React allows you to render different UI elements or components based on certain conditions.

### Examples:

**Using `if` statement:**
```jsx
function Greeting(props) {
  if (props.isLoggedIn) {
    return <h1>Welcome back!</h1>;
  }
  return <h1>Please sign up.</h1>;
}
```

**Using ternary operator:**
```jsx
const isLoggedIn = true;
const message = isLoggedIn ? "Welcome back!" : "Please sign up.";
```

**Using logical `&&` operator:**
```jsx
{unreadMessages.length > 0 && <h2>You have {unreadMessages.length} unread messages.</h2>}
```

---

## 2. Element Variables

Element variables are used to store elements in variables, allowing you to render them conditionally or dynamically.

### Example:
```jsx
function LoginControl(props) {
  const isLoggedIn = props.isLoggedIn;
  let button;

  if (isLoggedIn) {
    button = <LogoutButton />;
  } else {
    button = <LoginButton />;
  }

  return (
    <div>
      {button}
    </div>
  );
}
```

---

## 3. Preventing Component Rendering

To prevent a component from rendering, you can return `null` from its `render()` method or functional component.

### Example:
```jsx
function WarningBanner(props) {
  if (!props.warn) {
    return null; // Prevent rendering
  }

  return (
    <div className="warning">
      Warning!
    </div>
  );
}
```
Returning `null` tells React to render nothing for that component.
