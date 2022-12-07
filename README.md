# Final Exam TAE Academy

## Run project
Each feature (web and mobile) has to be executed from its own runner class, located at ``src > test > java > org > finalExamTae > runners``


### Execution
* To run the web test you only need to run "RunCucumberTestsWeb"


* To run the mobile test you must download ``DisneylandÂ®_7.17_Apkpure.apk``, the test could fail with other versions, since some elements may or not be present, then go to `src\test\resources\mobile_capabilities.json`and modify `app` with th absolute path of the location where your app was downloaded.