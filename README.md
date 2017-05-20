# A Knight's Journey
Developed by Kenny Chow

## Build
If you received the source as a zip file, extract it first. Otherwise, clone it from the following repo:
`https://github.com/kenny-chow-my/knightjourney.git`

1. Install Maven. Download and install from https://maven.apache.org/download.cgi
2. Run `mvn clean` in the source folder of this project
3. Run `mvn package` to build an executable jar. See Usage for info on how to run the executable jar.

A resulting `KnightJourney-1.0.jar` is generated under the `target` folder.


## Tests
1. Run `mvn test` in the source folder of this project

Alternatively, use JUnit to run the tests located under the `src/test` folder.


## Usage
Execute the jar file `KnightsJourney-1.0.jar`.

Example:
`java -jar KnightJourney-1.0.jar [m] [n] [x] [y]`

## Tech details
The programs solves for a given board size m x n, all the possible moves a Knight in a chess game can move given a starting position x and y. It gives the minimum number of moves required to reach a certain position in the board.

There are 2 algorithms provided:
 - Naive algo: tries every possible position starting from (x,y) and increments a count for each successful hop.
 - Parallel algo: this is basically the Naive algo with worker threads added so it solves from multiple starting positions.
 
### Future enhancement
A pattern emerges when looking at the result. All solutions across a diagonal side of a board is mirrored across its opposite side.

Example:
```
m = 6, n = 6, x = 2, y = 2

4 1 2 1 4
1 2 3 2 1
2 3 0 3 2
1 2 3 2 1
4 1 2 1 4
```

The upper left diagonal is equal to the lower right diagonal and vice versa for the upper right / lower left.
```
4 1 2 1 4           
1 2 3 2             
2 3 0            
1 2                 
4 
  is mirrored across
        4
      2 1 
    0 3 2
  2 3 2 1
4 1 2 1 4
```

An enhancement to the above algorightms is to compute only the larger side of the diagonal, and then flip it across for the full solution. It will reduce the number of solves by half which should decrease the time it takes to solve large board sizes by half.