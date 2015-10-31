'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('my app', function() {

	describe('current weather view', function() {

		var cityName = element(by.id('cityName'));

		beforeEach(function() {
			browser.get('index.html');
		});

		it('should read weather information of Melbourne', function() {

			element(by.id('cityList')).then(function(options) {
				options[1].click();
			});

			expect(cityName).getText().toEqual('Melbourne');
		});

	});

});
