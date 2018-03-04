# AVeryResponsibleApp5.0 

App description: see below, under AVeryResponsibleApp1.0, at "APP DESCRIPTION - GOALS AND CONTEXT".

Background: submitted for Android Basics Nanodegree by Google at Udacity, Feb. 25. 2018, Project 2) & modified after reviewer feedback.
Changes since AVeryResponsibleApp4.0:

(1) Removed hardcoded toasts from Java and referenced it from strings.xml. 
(2) GameOver toast was useless as specified, as score could not go over 18, SoberQuiz kicks in at13. So got rid of GameOver toast. 
(3) readme changes (typos). 
(4) Got rid of unused import statements. (5) Set targetSdkVersion to latest (27).


# AVeryResponsibleApp4.0 (Android Basics Nanodegree by Google at Udacity, Feb. 25. 2018, Project 2)

App description: see below, under AVeryResponsibleApp1.0, at "APP DESCRIPTION - GOALS AND CONTEXT".

Background: the app was created as PROJECT 2 for the Google Developer Challenge Scholarship (phase 1) in Jan, 2018, and carried over as project 2 for the present phase of the scholarship as permitted by Udacity (i.e. First General AMA session: "As long as your work is original work, you may carry over work from the first Phase into this Phase."). 

Main changes to the phase 1 version(s): see right here below and also under AVeryResponsibleApp3.0.

- New launcher icon, with several scaled versions to fit various device sizes. 
- When Start Quit button is displayed, no EditText is apparent on the screen anymore, it gets to set visible when the first quiz question appears. 
- Code comments (in detail) added. 
- At the end of quiz, not the background of the ScrollView is changed (see previous version) but an ImageView is set to visible from its hitherto gone state.  
- Managed to accomplish the previous version's TODO2, but not TODO1 and 3. So, background drawable problems are fixed when a picture is displayed at the end of the quiz upon user failing it. 
- ISSUES/Remaining TODO's for the future:

TODO (1): find a way to pass original alcohol and water score to second activity and from there back to the main one if user gets sent back there (they get reset instead). I can pass it tothe second activity but cannot pass it back to the first one upon user being re-sent there.

TODO (2): make sure pop-up keyboard stops appearing once user failed the quiz in SoberActivity. `getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);` and

`InputMethodManager im=(InputMethodManager)getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);`
`im.hideSoftInputFromWindow(rootView.getWindowToken(),0); `
do NOT work.

# AVeryResponsibleApp3.0 (Android Basics Nanodegree by Google at Udacity, Feb. 2018, Project 2)
Fixed some issues with the second activity (SoberActivity). 
- Added content to SoberActivity (e.g. background drawable changes if soberness score proves low at the end of the quiz, and goHomeMessage is displayed); 
- Saves views, eventScore and background on rotation; 
- Sends user back (intent) to original score counter (MainActivity) if soberness score proves high enough at the end of the soberness quiz. 
- Scaled images to various sizes using Android Drawable Importer (installed plugin). 

TODO (1): so far could not manage to pass original alcohol and water score to second activity and from there back to the main one if user gets sent back there (they get reset instead).

TODO (2): SoberActivity's background drawable looks strange on the screen when changed upon user failing the quiz. Both on portrait and landscape. Should rescale/recut portrait version, and create a separate landscape layout to be able to use a differently cut, landscape-friendly version of the same picture.

TODO (3): make sure pop-up keyboard stops appearing once user failed the quiz in SoberActivity. `getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);` does NOT work.

# AVeryResponsibleApp2.0 (Udacity Google Developer Challenge Scholarship 2017, Project 2)
Layout changes for readability, and added one more activity (soberness quiz). TODO: added activity's java needs some fixing.

Changes to previous version (AVeryResponsibleApp):
Layout:
- it uses a different measurement for strong and weak alcohol (dl vs cl);
- the RESET button received a larger font;
- the displayed text was slightly changed (simplified) (e.g., ”lvl” was deleted);
- a completely different background image for both sides (alcohol and water);
- changed text colours and text sizes for both the unit counters and the alcohol & water text views;
- moved a lot of the layout.xml into styles and referenced them from there.

Java:
- a new activity was added (wrapped in ScrollView so that no separate layout-land is needed), making the app multiscreen: after the alcohol units reach 13, a quiz page pops up and begins to test user on their basic math;
- after 5 calculations, app calculates soberness (correctness) score, and if it reaches 3 or more out of 5, it displays a positive toast, if not, it displays a toast saying ”Go home friend, you’re drunk!”

TODO: the java is not perfect yet.
- Now user has to press the submit Quiz button more than once to get the next calculation displayed.
- The mid-quiz toasts (wrong/correct notifications) misbehave sometimes (correctness notification appears when shouldn't).
- Next: after fixing these, the plan is to send the sober enough user back to mainActivity.java so that they can continue drinking.
The drunk user might get brought to a new activity displaying a skull or something (I could even do this within the quiz activity by changing what appears on the screen).

# AVeryResponsibleApp1.0 (Udacity Google Developer Challenge Scholarship 2017, Project 2) - APP DESCRIPTION - GOALS AND CONTEXT

 This app has been designed to track the user's alcohol and water/soft drink intake. 
 Water is used to refer to both water and soft drinks here, as the component of water is the vital point here. 
 The soft drink button has a lower score than the water button, the latter being "more concentrated water". 
 It is also designed to keep the user hydrated. Each alcohol intake incurs a score rise on the water side too, 
 as the latter keeps track of the water intake "needed". 
 The user is complimented, advised or warned (in the form of toast messages) on each button press based on their overall alcohol score,
 their overall water score, and on the proportion of the two. 

 Very high alcohol intake trigger serious warning messages no matter the water intake. 
 (=User drank way too much alcohol.)
 High alcohol intake and high water "needed" trigger somewhat less serious warning messages and advices. 
 (=User drank a lot, and has a high water "debt".)
 High alcohol intake and low water intake "needed" trigger advices on drinking more water, not alcohol. 
 (User drank a lot of alcohol, but a lot of water too - their water "debt" is low.)
 Low alcohol intake and high water intake "needed" trigger compliments and, as the water intake itself increases, humorous lines.
(= User drinks little to no alcohol, and drinks a lot of water.) 
 Lines for the latter case: "With great power comes great responsibility.", "Not judging you. Honest."

 There is an "UNDO" button for each intake button (for both alcohol and water), 
 to take back an added score if drinking button was pressed by accident. This is a drinking app after all.

