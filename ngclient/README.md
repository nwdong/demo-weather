# project background
this project is a front end implementation of autoreplier based on angular-seed (https://github.com/angular/angular-seed/)

# install dependencies
execute "npm install" in project folder

if unable to get npm install to run on Windows 7 64 bit, check https://github.com/angular/angular-seed/issues/262
npm install -g phantomjs
Then
npm install

dependencies installed
node_modules - contains the npm packages for the tools we need
app/bower_components - contains the angular framework files

# how to run application
npm start

# how to run unit tests
npm test

# how to run e2e tests based on Node.JS
command window 1
go to project folder
- npm run update-webdriver (once)
- npm start

command window 2
go to project folder
- npm run protractor