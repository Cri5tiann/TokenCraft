# TokenCraft 🔄

<div align="center">

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Version](https://img.shields.io/badge/version-1.0.0-green.svg)](https://github.com/yourusername/TokenCraft)

</div>

---

> A user-friendly programming language compiler with clear syntax and easy-to-understand output.

<details>
<summary>📋 Table of Contents</summary>

- [What is TokenCraft?](#what-is-tokencraft)
- [Features](#-features)
- [Quick Start](#-quick-start)
- [Writing PLT Programs](#-writing-plt-programs)
- [Examples](#-examples)
- [Common Questions](#-common-questions)
- [Getting Help](#-getting-help)
- [Contributing](#-contributing)
- [License](#-license)

</details>

## What is TokenCraft?

TokenCraft is a programming language tool that helps you write and understand code better. It takes your code written in PLT (Programming Language TokenCraft) and turns it into a clear, visual representation that shows how your program is structured.

## ✨ Features

- **Easy to Write**
  - Simple, clean syntax similar to popular programming languages
  - Intuitive control structures
  - Straightforward function declarations

- **Visual Output**
  - Tree-like diagrams of program structure
  - Clear representation of code hierarchy
  - Easy-to-follow program flow

- **Helpful Errors**
  - Precise error locations
  - Clear error descriptions
  - Suggested fixes

## 🚀 Quick Start

### Installation

```bash
# Clone the repository
git clone https://github.com/yourusername/TokenCraft.git

# Navigate to project directory
cd TokenCraft

# Build the project
./build.sh  # or build.bat on Windows
```

### First Program

1. Create a file `hello.plt`:

   ```plt
   function main() {
       x = input_int();
       output_int(x * 2);
   }
   ```

2. Run it:

   ```bash
   java TokenCraft hello.plt
   ```

## 📝 Writing PLT Programs

### Basic Syntax

Every program needs:

- `function main()` declaration
- Semicolons (`;`) after statements
- Curly braces (`{}`) for blocks

### Control Structures

<details>
<summary>If-Else Statement</summary>

```plt
if (x > 0) {
    output_int(x);
} else {
    output_int(0);
}
```
</details>

<details>
<summary>For Loop</summary>

```plt
for (i = 0; i < 10; i++) {
    output_int(i);
}
```
</details>

### Operators

|
 Category 
|
 Operators 
|
----------
|
|
 Math 
|
`+`
, 
`-`
, 
`*`
, 
`/`
, 
`%`
|
|
 Comparison 
|
`<`
, 
`<=`
, 
`>`
, 
`>=`
, 
`==`
|
|
 Logic 
|
`&&`
 (and), \|\| (or) 
|
|
 Assignment 
|
`=`
|
|
 Increment/Decrement 
|
`++`
, 
`--`
|

## 🔍 Examples

<details>
<summary>Calculator Program</summary>

```plt
function main() {
    x = input_int();
    y = input_int();
    
    output_int(x + y);  // Addition
    output_int(x * y);  // Multiplication
}
```
</details>

<details>
<summary>Number Checker</summary>

```plt
function main() {
    num = input_int();
    
    if (num > 0) {
        output_int(1);
    } else {
        if (num < 0) {
            output_int(-1);
        } else {
            output_int(0);
        }
    }
}
```
</details>

## ❓ Common Questions

<details>
<summary><b>How do I input multiple numbers?</b></summary>

Use `input_int()` multiple times:
```plt
x = input_int();
y = input_int();
```
</details>

<details>
<summary><b>Why doesn't my program work?</b></summary>

Check for:
- Missing semicolons (`;`)
- Missing curly braces (`{}`)
- Mismatched parentheses
</details>

## 🆘 Getting Help
- **Documentation**: See our [Technical Documentation][docs]


## 📄 License

TokenCraft is MIT licensed. See [LICENSE](LICENSE) for details.

---

<div align="center">

**[Documentation][docs]** 

Made with student passion by Cristian
