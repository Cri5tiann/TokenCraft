
## What is TokenCraft?

TokenCraft is a programming language tool that helps you write and understand code better. It takes your code written in PLT (Programming Language TokenCraft) and turns it into a clear, visual representation that shows how your program is structured.



## Quick Start

### Installation

```bash
# Clone the repository
git clone https://github.com/Cri5tiann/TokenCraft.git

# Navigate to project directory
cd java

# Build the project
run the Main class and see what a great small project I built))
```

## Writing PLT Programs

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

## Examples

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

## Common Questions

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

---

<div align="center">

**[Documentation][docs]** 

Made with student passion by Cristian
