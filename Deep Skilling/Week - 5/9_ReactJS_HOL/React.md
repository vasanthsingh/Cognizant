# Assignment
## 1. List the Features of ES6

ES6 (ECMAScript 2015) introduced major improvements and new features to JavaScript, making it easier, cleaner, and more powerful to write code. Key features include:

- **let** and **const** for block-scoped variable declarations
- **Arrow functions** for concise function syntax
- **Classes** for object-oriented programming
- **Template literals** for embedded expressions in strings (`` `Hello, ${name}` ``)
- **Default, rest, and spread parameters** in functions (`function f(a=1, ...args)`)
- **Destructuring assignment** for arrays and objects
- **Enhanced object literals** (shorthand property names, computed property names)
- **Modules** with `import` and `export`
- **Promises** for easier asynchronous code
- **Symbol** data type for unique identifiers
- **Map** and **Set** data structures
- **for...of** loop for iterable objects
- **Generators** (`function*`) and iterators

---

## 2. Explain JavaScript `let`

The `let` keyword introduces block-scoped variables in JavaScript. Unlike `var`, which has function or global scope, variables declared with `let` only exist within the block they are defined in (such as within `{}` braces).

**Example:**
{
let x = 10;
// x is accessible here
}
// x is NOT accessible here


**Features:**
- No variable hoisting (cannot be used before declaration in the same scope)
- Cannot be redeclared in the same scope
- Block-scoped (not function or global-scoped)

---

## 3. Identify the Differences Between `var` and `let`

| Aspect           | `var`                        | `let`                     |
|------------------|-----------------------------|---------------------------|
| Scope            | Function/global-scoped       | Block-scoped (`{}`)       |
| Redeclaration    | Can be redeclared            | Cannot be redeclared      |
| Hoisting         | Hoisted, initialized as `undefined` | Hoisted but not initialized ("temporal dead zone") |
| Usage in Loops   | Not block-scoped in loops    | Block-scoped in loops     |

**Example:**
function test() {
if (true) {
var x = 5;
let y = 10;
}
console.log(x); // 5
console.log(y); // ReferenceError
}
test();


---

## 4. Explain JavaScript `const`

The `const` keyword is used to declare block-scoped variables whose value cannot be reassigned after initialization.

**Features:**
- Block-scoped like `let`
- Must be assigned a value at declaration
- The binding is constant, but object/array contents are still mutable

**Example:**
const x = 10;
x = 20; // Error: Assignment to constant variable

const arr = ;
arr.push(4); // Allowed, array content can change


---

## 5. Explain ES6 Class Fundamentals

ES6 introduces a simpler and cleaner syntax for working with prototypes and constructor functions using the `class` keyword.

**Features:**
- Mimics classical inheritance with `constructor`, `methods`, and `extends`
- Methods are defined inside the class body
- Can have getters, setters, static methods

**Example:**
class Person {
constructor(name) {
this.name = name;
}
greet() {
return Hello, ${this.name}!;
}
}

const p = new Person('Alice');
console.log(p.greet()); // Hello, Alice!


---

## 6. Explain ES6 Class Inheritance

ES6 classes support inheritance using `extends` and `super` keywords.

**How it works:**
- `extends` allows one class to inherit from another
- `super` calls the parent class constructor

**Example:**
class Animal {
constructor(name) {
this.name = name;
}
speak() {
return ${this.name} makes a noise.;
}
}

class Dog extends Animal {
speak() {
return ${this.name} barks.;
}
}

const d = new Dog('Rex');
console.log(d.speak()); 


---

## 7. Define ES6 Arrow Functions

Arrow functions provide a concise syntax for writing functions and automatically bind the `this` value from the surrounding context (lexical scoping).

**Syntax:**
const add = (a, b) => a + b;

// with one parameter, parentheses can be omitted
const square = x => x * x;

// more than one statement requires curly braces and an explicit return
const multiply = (a, b) => {
const result = a * b;
return result;
};

**Key points:**
- Shorter syntax
- Don't have their own `this`, `arguments`, or `super`
- Cannot be used as constructors

---

## 8. Identify `set()` and `map()`

### `Set`

- ES6 `Set` is a collection of unique values (no duplicates).
- Supports values of any type.
- Common methods: `add()`, `has()`, `delete()`, and iteration.

**Example:**
const mySet = new Set();
mySet.add(1);
mySet.add(2);
mySet.add(2); 
console.log(mySet.has(1)); 
console.log(mySet.size); 


### `Map`

- ES6 `Map` is a collection of key-value pairs.
- Keys can be of any type (objects, functions, primitives).
- Preserves insertion order.

**Example:**
const myMap = new Map();
myMap.set('a', 1);
myMap.set({key: 'obj'}, 2);
console.log(myMap.get('a')); 
console.log(myMap.size); 

