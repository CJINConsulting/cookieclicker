# Test Approach

Based on the initial requirements, I've added more than the initial goal to give us more scope for growth. The task is open-ended, and the initial assumption is the framework will need be expanded over time.

Some things are included which may seem like overkill to perform this one test, and they will help immediately should the next steps include:

- adding more tests to this area
- including other browsers and configurations
- adding more UIs
- testing in other environments

Ideally, these are all decisions I would have made with the wider team during the sprint.

## Assumptions

- One browser has been added so far. As the site appears to be customer-facing, I expect that there are requirements for browsers, versions, devices, screen sizes etc
- This framework will need to be run by anyone in the team, or even CI. Started the process of adding drivers into the framework in case some don't have the browsers installed. Could also limit this to certain environments in the hooks if we wanted to run our own versions locally
- Likely there are dev, test, CI environments to consider. Added a sample config file, but not yet hooked into the framework
- Cookie banner will currently always be accepted. We may need to amend this in future if we have requirements to test different cookie configurations.
- Driver management hardcoded to maximise the browser window. The UI is dynamic at certain screen sizes and hides the menu behind a menu 'hamburger'
- Chose some locators to be Xpath as it was more clear than using some of the css selectors, and will likely be a negligible performance hit

## Questions
- The initial tech stack included Java, Selenium, Cucumber. Is this all we could use? Or could we add in some dependency injection like Spring, picocontainer, or possibly a framework like SerenityBDD?
- Are there any platforms we can use to expand browser, version, device testing like Browserstack?
- No requirements mention an app. Is there anything that uses our site inside a hybrid app?
- Do we need to consider mac users in the team? (config, path settings in the framework may need to consider windows and mac)