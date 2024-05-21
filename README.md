# Technical Test
## Challenge Details

There is a simple web application currently running at this location:

https://colin-piper-2024-05-20.cookieclickertechtest.airelogic.com/

It’s a simple (and very buggy) clone of the highly popular cookie clicker game.

Of which the original can be seen here:
- https://orteil.dashnet.org/cookieclicker/

Not sure what Cooky Clicker is? Check out its wiki page here:
- https://en.wikipedia.org/wiki/Cookie_Clicker

### Tasks

- Your task is to produce some tests for this application, using whatever approach and tools you like.
- Please send us a list of the scenarios you have created as Manual or Automation scripts. 
- Be sure to send us any code you produce, this can be in a GIT repo of your choosing. For example https://bitbucket.org/
- List any bugs that you identify
- We don't expect you to spend more than 4 hours on this but if you choose to spend more it's entirely up to you. So don't worry if there's more you would have liked to have done, but feel free to mention "if I'd had more time, I would have liked to..." etc.

## Test Approach
We are testing the game with no prior knowledge of how the game looks or works.
The only information available is the comparable game, and the wiki documentation that explains how this type of game may work.

We're looking to see how consistent our clicker is with those resources. Comparing the available functionality, and how that functionality affects the game.

### Scope
We are limiting the scope to the wiki documentation, and how it works compared to the example game.
We don't have any explicit requirements for how our clicker should behave, so we can only use the reference material as a guide.

In the real world, we would be able to explore, ask questions, and expand further.

## Defects
### General
- There is no help documentation to understand the rules and config for the game.
  - Even assuming a base understanding of the game type, we don't know how much the cookies cost, or the impact of factories
- The game URLs seem to use the full username provided. May be a better experience to use something like a game ID so the URLs don't get too big.

### New Game
- The game allows you to start without entering a name value
  - This name value is used as a link in the high score records. If no name is entered, there's no way to continue that game via the UI.
  - Also allows entering the name as a space character, which creates a new record on the high score page, but also has no link to continue the game
- The name field allows names without alphanumeric characters
  - https://colin-piper-2024-05-20.cookieclickertechtest.airelogic.com/game/1232131
- The name field doesn't display accented characters correctly on the game page or the high score page
    - Example: àáâãäåçèéêëìíîðñòôõöö shows as ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
    - https://colin-piper-2024-05-20.cookieclickertechtest.airelogic.com/game/%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD
- The name field doesn't display some special characters correctly:
  - These characters (‘“/£) display as "ï¿½" 
  - Forward slashes "/" are treated as a space e.g. "Joh/n" is displayed as "Joh n"
  - https://colin-piper-2024-05-20.cookieclickertechtest.airelogic.com/game/%EF%BF%BD%20%EF%BF%BD%20%60%20%7C%20/%20%5C%20%2C%20%3B%20%3A%20%26%20%3C%20%3E%20%5E%20%2A%20%3F%20Tab
- The name field reduces multiple internal spaces to 1. E.g. "Joh  n" is updated to "Joh n" 
  - https://colin-piper-2024-05-20.cookieclickertechtest.airelogic.com/game/Joh%20%20n
- When starting a new game, if the new user name matches an existing name on the high score table, it overwrites the records
  - This appears to be undesired behaviour, as you can resume a cookie run by clicking on the username link in the high score table

### High Scores
- Entering long names distorts the high score table so that the scores are hard to check
  - the name string appears to wrap if it exceeds 278 chars
  - https://colin-piper-2024-05-20.cookieclickertechtest.airelogic.com/game/Accusantium%20reprehenderit%20quae%20consequuntur%20cumque%20ut%20rerum.Nostrum%20quos%20ab%20libero%20laboriosam.Provident%20at%20magni%20hic%20aperiam.Dicta%20et%20magnam.Vero%20aut%20et%20perspiciatis%20vel%20exercitationem%20cum.In%20omnis%20quam.Quasi%20alias%20sint%20enim%20voluptas%20impedit%20omnis%20quae.Asperiores%20neque%20numquam%20voluptatibus%20minus.Necessitatibus%20voluptatibus%20consequuntur.Ipsum%20tenetur%20sed%20veritatis%20hic%20quae.Aliquid%20excepturi%20qui%20commodi%20sunt%20et%20suscipit.Incidunt%20tenetur%20nisi.Aperiam%20incidunt%20consequatur.Commodi%20est%20blanditiis%20suscipit%20saepe%20voluptatibus.Non%20non%20optio%20non%20explicabo%20atque%20rerum.Atque%20est%20qui.Quia%20tempore%20laudantium%20placeat.Possimus%20quia%20eaque%20nisi%20id%20perspiciatis%20sit%20exercitationem.Nulla%20sed%20atque%20laboriosam%20expedita%20consectetur%20nostrum%20sunt.Quisquam%20quis%20doloribus%20recusandae%20rem%20porro%20ea.Impedit%20quae%20eos%20et%20qui%20voluptatem%20ex.Qui%20voluptas%20quis%20natus.Aut%20hic%20ut%20accusamus%20omnis%20ducimus%20illo%20unde.Vitae%20facilis%20quia.Hic%20voluptatem%20perspiciatis%20in%20voluptas.Sapiente%20sed%20asperiores%20error%20rem.Optio%20suscipit%20tempor
- The table is not sorted by highest score descending. Most high score tables rank the best scores
  - https://colin-piper-2024-05-20.cookieclickertechtest.airelogic.com/

### Gameplay
- Clicking sell cookies button with no value, or a non-numeric value gives no response to say it's invalid
- Clicking buy factories button with no value, or a non-numeric value gives no response to say it's invalid
- There's no facility to sell factories
  - Could be a decision not to add rather than a bug. The comparable game has that feature.
- The sell factories allows me to enter negative values
  - Selling 1 cookie reduces the money total by $-0.25, and adds 1 to the cookie total
  - If the money total is negative, Selling a positive value of cookies increases the money total and reduces the cookie counter
- I'm unable to sell all of my cookies. If I have 15, I can only sell 14. Once I have started clicking cookies I can never go back to 0
- I can buy factories before I have enough money
  - Buying the factory puts the money total into a negative amount
  - Selling cookies reduces the debt, and the cookie count now seems to go down until you have no more cookies to sell
- When the counter values hit a certain number, the value presented to the player is in scientific notation
  - This number is around 10^21 though
- The factory prices are static at $3. Resources in the example game increase in price by 15% each time you buy one.
- You can sell cookies in non-integer values e.g. 1.1, 10.5 etc
  - The cookie value is consistent, but doesn't appear to change the total cookie value to a non-integer value
- You can buy factories in non-integer values e.g. 1.1, 10.5 etc
- The number of factories can show as a non-integer number e.g. 25.00000000000001
- The money total can be shown with a decimal value greater than 2 e.g. $136.7250000000001

## Questions
I didn't think these were obvious issues, but they were worth asking in case they hadn't already been considered.

- The game page constantly polls a status POST message, every second.
  - Is this for handling factory cookie production?
  - Is the poll for any other behaviour?

- The game is missing a lot of visuals and functionality compared to the example game. 
  - Does it look right based on the stage of development we're currently at?
  - How is this game going to compare to the example and the wiki in the future?

## Future Tests
The functionality described below is based on features that are described in the documentation. 
They don't yet exist in our app, but may need to be considered in the future.

### Additional Means of Production
The current game functionality doesn't yet include a click enhancer that is available in the comparison app.

### Achievements
There are no achievements yet. These seem to be based around very specific landmarks of cookies, factories, enhancements etc.
May need a way to set the game session to very specific values in order to consistently test them quickly.

### Mini Games
We don't currently have any mini games.

### Time-based
Randomly generated scenarios would need some ability to generate them on-command in order to have reliably test their effects. 
We may also need a way to disable them when not directly testing them.

#### Golden cookies
These appear periodically in random locations on-screen, and fade away after a few seconds.

#### Wrinklers
These may appear periodically, and appear to stay until the player takes action. No details on how quickly they could appear.

#### Krumblor the cookie dragon
No current documentation on this gameplay element.

#### Sugar Lumps
These would only appear after 24h. Would need some ability to generate on-command to see its effects on the game.

### Performance
From the fully-featured game, there are at least 2 performance angles.
- Cookie Generation
- Click Rate

The wiki states that the game can handle at least numbers into the duodecillions (10^39).

Based on the performance numbers, it's likely impossible to hit a number that big in a number of lifetimes without a similarly massive cookie rate.
- (1 duodecillion (1,000,000,000,000,000,000,000,000,000,000,000,000,000))
- We'd need a cookie rate of above 10,000,000,000,000,000,000,000,000,000,000,000,000 to keep the test under 100 secs

We may be able to facilitate a stress test to manage the speed of cookie generation by using 'additional means of production', rather than just using raw mouse clicks.

### Framework
Some other future things to work on from the framework perspective:

- including other browsers and configurations
- testing in other environments (local, dev, staging etc)

Ideally, these are all decisions I would make with the wider team during the project.

## Assumptions

- One browser has been added so far. As the site appears to be player-facing, I expect that there are requirements for browsers, versions, devices, screen sizes etc
- This framework will need to be run by anyone in the team, or even CI. Started the process of adding drivers into the framework in case some don't have the browsers installed. Could also limit this to certain environments in the hooks if we wanted to run our own versions locally
- Likely there are dev, test, CI environments to consider. Added a sample config file, but not yet hooked into the framework
- Driver management hardcoded to maximise the browser window. The UI is not currently dynamic so may not work well on smaller windows.
- Chose some locators to be Xpath as it was more clear than using some of the css selectors, and will likely be a negligible performance hit

## Questions

- Are there any platforms we can use to expand browser, version, device testing like Browserstack?
- No requirements mention an app. Is there anything that uses our site inside a hybrid app?
- Do we need to consider mac users in the team? (config, path settings in the framework may need to consider windows and mac)






