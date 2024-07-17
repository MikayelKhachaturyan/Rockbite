# Rockbite

In this repository, I implement a task for Rockbite as a Java engineer. You can find the task details via the following [link](https://docs.google.com/document/d/1wU8DQgKbrZFo339UeqLqgrz01vDkK-ijVOIOEFrmK0k/edit).

This repository contains a small Java project which takes an integer `N` and outputs the  scaled version of reward pattern `'bbbbbbbbbsbbbbbbbbsbbbsbbbsbbbbsbsbbsbsbbsbbsbsbsbsbssbsbsbsbsbsssbsssbssbssbsssssbssssssbssssssssss'` to a length `N`, which mimics the statistical structure of the initial string in terms of 'b' and 's' occurrences.

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
   java -cp app application.Main <N> 
   ```
   here
   - `<N>`: Replace with the desired length of the resulting pattern.

### Example

To scale the pattern to a length `500`, use:
   ```sh
   java -cp app application.Main 500


