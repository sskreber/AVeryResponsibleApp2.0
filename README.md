# AVeryResponsibleApp4.0 (Android Basics Nanodegree by Google at Udacity, Feb. 25. 2018, Project 2)

- New launcher icon, with several scaled versions to fit various device sizes. 
- When Start Quit button is displayed, no EditText is apparent on the screen anymore, it gets to set visible when the first quiz question appears. 
- Code comments (in detail) added. 
- At the end of quiz, not the background of the ScrollView is changed (see previous version) but an ImageView is set to visible from its hitherto gone state.  

# AVeryResponsibleApp3.0 (Android Basics Nanodegree by Google at Udacity, Feb. 2018, Project 2)
Fixed some issues with the second activity (SoberActivity). 
- Added content to SoberActivity (e.g. background drawable changes is soberness score proves low at the end of the quiz, and goHomeMessage is displayed); 
- Saves views, eventScore and background on rotation; 
- Sends user back (intent) to original score counter (MainActivity) if soberness score proves high enough at the end of the soberness quiz. 
- Scaled images to various sizes using Android DRawable Importer (installed plugin). 

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
- a new activity was added (wrapped in ScrollView so that no separate layout-land is needed), making the app multiscreen: after the alcohol units reach 15, a quiz page pops up and begins to test user on their basic math;
- after 5 calculations, app calculates soberness (correctness) score, and if it reaches 3 or more out of 5, it displays a positive toast, if not, it displays a toast saying ”Go home friend, you’re drunk!”

TODO: the java is not perfect yet.
- Now user has to press the submit Quiz button more than once to get the next calculation displayed.
- The mid-quiz toasts (wrong/correct notifications) misbehave sometimes (correctness notification appears when shouldn't).
- Next: after fixing these, the plan is to send the sober enough user back to mainActivity.java so that they can continue drinking.
The drunk user might get brought to a new activity displaying a skull or something (I could even do this within the quiz activity by changing what appears on the screen).
