# TicToe-Game
This project is a basic Tic-Tac-Toe game developed in Java. It provides a graphical user interface for two players to play the game.

## Features
- Simple and intuitive GUI.
- Two-player mode.
- Basic game logic for Tic-Tac-Toe.

## Technologies
- `Java`
- `MinMax Algorithm`

## Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/gamalahmedd/TicToe-Game.git
    ```
2. Open the project in NetBeans 8.2 IDE

## Working of MinMax Algorithm
1. In the first step, the algorithm generates the entire game-tree and apply the utility function to get the utility values for the terminal states. In the below tree diagram, let's take A is the initial state of the tree. Suppose maximizer takes first turn which has worst-case initial value =- infinity, and minimizer will take next turn which has worst-case initial value = +infinity.

![alt text](https://static.javatpoint.com/tutorial/ai/images/mini-max-algorithm-in-ai-step1.png)

2. Now, first we find the utilities value for the Maximizer, its initial value is -∞, so we will compare each value in terminal state with initial value of Maximizer and determines the higher nodes values. It will find the maximum among the all.
    - For node D         max(-1,- -∞) => max(-1,4)= 4
    - For Node E         max(2, -∞) => max(2, 6)= 6
    - For Node F         max(-3, -∞) => max(-3,-5) = -3
    - For node G         max(0, -∞) = max(0, 7) = 7

![alt text](https://static.javatpoint.com/tutorial/ai/images/mini-max-algorithm-in-ai-step2.png)

3. In the next step, it's a turn for minimizer, so it will compare all nodes value with +∞, and will find the 3rd layer node values.
    - For node B= min(4,6) = 4
    - For node C= min (-3, 7) = -3

![alt text](https://static.javatpoint.com/tutorial/ai/images/mini-max-algorithm-in-ai-step3.png)

4. Now it's a turn for Maximizer, and it will again choose the maximum of all nodes value and find the maximum value for the root node. In this game tree, there are only 4 layers, hence we reach immediately to the root node, but in real games, there will be more than 4 layers.
    - For node A max(4, -3)= 4

![alt text](https://static.javatpoint.com/tutorial/ai/images/mini-max-algorithm-in-ai-step4.png)

## Screenshots
![alt text](https://serving.photos.photobox.com/29204512de3868c2c0b4cd3c468f7be928f4ed1564b2399ebd2c3886ab3c3f2711a12e0d.jpg)

![alt text](https://serving.photos.photobox.com/618213622cbf1fec9535576aa8330a2b6f899ee1ad5ada7aea59a25ce7dc1f52d8c177d4.jpg)


## Usage
1. Run the `Main` class located in the `src` directory.
2. The game window will appear, and you can start playing.

## License
This project is licensed under the Mozilla Public License 2.0. See the [LICENSE](LICENSE) file for details.