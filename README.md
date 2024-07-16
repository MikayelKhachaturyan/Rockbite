# Rockbite

In this repository, I implement a task for Rockbite as a Java engineer. You can find the task details via the following [link](https://docs.google.com/document/d/1wU8DQgKbrZFo339UeqLqgrz01vDkK-ijVOIOEFrmK0k/edit).

This repository contains a small Java project that takes a pattern of the form `'bbbbbssbbbbsbbb'` (consisting of two characters 'b' and 's'), an integer `N`, and a method of interpolation, and outputs a new string of length `N` that mimics the statistical structure of the initial string in terms of 'b' and 's' occurrences.

## Getting Started

To run the application after checking out the repository on your computer, you need to compile it using `javac` and run it with `java`. Follow the steps below:

### Prerequisites

- Java Development Kit (JDK) installed
- Command line access

### Steps

1. **Open Command Line**:

   Open your command line interface (CLI).

2. **Navigate to the Source Folder**:

   Navigate to the `Rockbite` folder in the repository, which contains the source files:

   ```sh
   cd path/to/Rockbite
3. **Compile the Source Files:**
   ```sh
   javac -d app src/main/java/application/*.java src/main/java/core/*.java

This will create a folder named `app` containing the compiled class files.

4. **Run the Application:**
   ```sh
   java -cp app application.Main <pattern> <N> <interpolation_method>
   ```
   here
   - `<pattern>`: Replace with the pattern you want to scale (e.g., `bbbbbssbbbbsbbb`).
   - `<N>`: Replace with the desired length of the resulting pattern.
   - `<interpolation_method>`: Replace with one of the following interpolation methods:
      - linear

### Example

To run the application with a pattern `bbbbbssbbbbsbbb`, length `20`, and interpolation method `linear`, use:
   ```sh
   java -cp app application.Main bbbbbssbbbbsbbb 20 linear


