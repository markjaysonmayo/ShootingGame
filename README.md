# ShootingGame
## Collaborators
### Karl Denzel Dayrit
### Mark Jayson Mayo

## Specifications
Upon creation, the ship is given an initial x position equal to 150, initial y position equal to 250 and a randomized initial
strength between 100-150. The ship can move by 10 pixels at a time. The ship can also shoot bullets when the
spacebar is pressed. The bullets shot by the ship move towards the right side of the screen in a straight line and
disappear when the end of the screen is reached. The bullet’s damage is equal to the current ship strength.
Many disturbed fish appear from the right side of the screen in random positions. A fish glides towards the left side
and back. A fish is initially alive and has a random movement speed between 1-5, inclusive. At the start, there are 7 fish
but 3 more are spawned every 5 seconds.

When a fish hits the ship, the ship’s strength is reduced by 30, and the fish dies and disappears. When the ship’s
strength reaches 0, the game is over and the ship loses. When a fish is hit by the ship’s bullet, it immediately dies and
disappears from the screen.
The game lasts for one minute. If the ship is still alive, the ship wins. A screen appears to display if the ship wins or
loses. The total number of fish that were killed are also displayed.
