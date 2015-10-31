'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('my app', function() {

	describe('current weather view', function() {

		var city = element(by.id('cityOption'));

		beforeEach(function() {
			browser.get('index.html');
		});

		it('should have city list', function() {
			
			var allOptions = element.all(by.options('option.name for option in cities track by option.id'));
			expect(allOptions.count()).toBeGreaterThan(3);
		});
		
		it('should have current weather information', function() {
			
			var options = element.all(by.css('select[ng-model="selectedCity"] option'));
			
			options.get(2).click();
			
			expect(element(by.id("temperature")).getText()).toContain('C');
			
			expect(element(by.id("wind")).getText()).toContain('km');
			
		});


	});

});
