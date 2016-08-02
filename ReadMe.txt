(c) Laxmikant Somni
laxmi.somni@gmail.com
Jul-Aug 2016

=========================
Note
=========================
Requirement:
Firefox 41.0 or earlier
(Make sure that Firefox is not on the most latest version as SeleniumHQ might not yet incorporated it in their supported version)

OS: Mac OS X
or Win 7/8

Java 7 - installed

1. I have created Couple of variants of this exercise.

All tests are build using standard packaging solution: Maven. 
& could be centrally deployed using standard POM.XML
Few tests are written in Cucumber BDD fashion and few in traditional TestNG driven

To Run Test:
a) Import Maven Dependencies (if not done earlier)
b) Option1: Right click on POM.XML & Run As> Maven Install
(This will in turn invoke TestNG driven tests on FireFox)
> Right Click on testng.xml & Run as > TestNg test

Option2: 
Right click on POM.XML & Run As> Maven Install
(This will in turn invoke TestNG driven tests on FireFox)
>From Project tree expand below package:
com.seleniumtests.test
> Then by right clicking Run WebDriverExcercise.java as TestNG test {Preferred way in local development env.}


c) If you would like to change the Browser then change browser value in testng.xml

2. Tests will create static snapshots at below folder
/LaxmiSearchScreenExcercise/target/snapshots

3. Tests will also create screen recordings & will store in 
/username/movies folder in Mac OS X environment
and 
/documents/Videos folder in Windows environment

4. TestNG result
/LaxmiSearchScreenExcercise/test-output/Default suite/Default test.html

=================================================
Challenges:
1. Haven't managed to complete BDD variant since feature files need to reviewed with Team / Business Analyst
2. Site is Graphics heavy with lots of dynamic JavaScript, which delays the loading of pages & sub-elements
[In future, we can look at implementing Headless testing (PhantomJS / HTMLUnitDriver etc..) for rapid execution]
3. Very limited number of ids are present in DOM so good study of DOM & HTML is necessary in order to build right locator strategy
[Currently I have used XPATH as I was not too familiar with DOM, but in future will need to look at using css, class, tagname etc.]
4. Due to technical issue SoftAsserts are not closing. Although they are working for each test but failing to closeAll. I mark this as OPEN-issue on myself.
5. Due to limited time available I was not able to complete test for filter.
6. Although Framework is robust, but I feel that- tests could have been more robust if we could have a Agile braintroming to define BDD tests
And what all aspects we want to validate using Automation.

Please feel free to get back to me.
Thanks


