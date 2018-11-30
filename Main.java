

import java.util.Scanner;

        public class Main {

        public static Scanner scan;
        public static int turns = 30;
        public static String output = "As you inspect the dimly lit foyer around yourself, you notice a caste iron door to your north with a brass knocker and engraved symbols.\n To your west lies a stout oaken bench with blood red cushions, it is pushed against the wall.\n To the east is plain ebony chest with a raven carved into it. \n In the center of the room lies a large wax candle. The candle is unlit, but it looks like it has been lit before.\n";


        public static boolean inFoyer = true;
        public static boolean inLibrary = false;
        public static boolean inConservatory = false;

        public static boolean lookedBench= false;
        public static boolean readNote= false;
        public static boolean chestOpen = false;
        public static boolean hasMatches = false;
        public static boolean candleLit = false;
        public static boolean DoorLocked2 = true;
        public static boolean DoorOpen2 = false;

        public static boolean getPen = false;
        public static boolean writeBook = true;
        public static boolean DoorLocked3 = true;
        public static boolean DoorOpen3 = false ;

        public static boolean trumpetAcquired = false;
        public static boolean playTrumpet = false;
        public static boolean playPiano = false;
        public static boolean playDrum = false;
        public static boolean DoorLocked4 = true;
        public static boolean DoorOpen4 = false ;
        public static boolean goDoor4 = false;
        public static boolean wentDoor = false;


        public static void main(String[] args) {


        System.out.printf("Welcome to the cursed mansion of Baron Von Strahd, you have but 30 turns to. You can enter the 2 word commands as verb-noun statements. The command [help] will remind you of the commands you can use, and [look] without a noun will restate the description of the room you are in.\n Your verbs are [open], [read], [look], [close], [write], [get], [light], and [play].\n Your nouns are [door], [candle], [book], [trumpet], [room], [note], [pen], [piano], [bench], [matches], [scroll], [drum], [chest], [shelves], [music], and [lock].\n To move, you can indicate direction with the commands {north], [go south], [go east], and [go west].\n Hurry before the Baron finds you!\n\n");

        for (int i = 1; i < 31; i++) {
        playGame();
        turns--;
        if (wentDoor) {
        break;
        }
        }

        if (wentDoor)

        {
            System.out.printf("\nSuccess! You're outside and away from danger. \nYou have escaped the Baron's mansion with %d spare turns, but will you be as lucky next time?", turns);
        }
        else {
        System.out.printf("\nYou see a dark cackling figure enter the door. You have been discovered and failed to escape in time!");
        }
        }

        public static void playGame() {
        if (inFoyer) {
        foyer();
        }
        else if (inLibrary) {
        library();
        }
        else if (inConservatory) {
        conservatory();
        }
        }


        public static void foyer() {
        System.out.printf("\n%s You have %d turns to escape.\n>>", output, turns);
        scan = new Scanner(System.in);
        String testFoyer = scan.nextLine();

        switch (testFoyer) {
        case "help":
        output = "Verbs are open, close, light, read, write, play, look, get. Nouns are door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock. Directions are north, south, east, west. \n";
        break;

        case "look":
        output = "As you inspect the dimly lit foyer around yourself, you notice a caste iron door to your north with a brass knocker and engraved symbols.\n To your west lies a stout oaken bench with blood red cushions, it is pushed against the wall.\n To the east is plain ebony chest with a raven carved into it. \nIn the center of the room lies a large wax candle. The candle is unlit, but it looks like it has been lit before.\n";
        break;

        case "look candle":
        output = "The candle is not lit.\n";
        break;

        case "look bench":
        lookedBench= true;
        output = "There is a small, torn note lying on the bench against the western wall.\n";
        break;

        case "read note":
        if (lookedBench){
        readNote= true;
        output = "Even with the poor handwritting, you can discern the phrase \"May my light show you the way\" from the note\n";
        }
        else {
        output= "There doesn't seem to be a note to read... Maybe if you looked around some more.\n";
        }
        break;


        case "look chest":
        output = "You see a plain, ebony chest resting on the floor. It has the engraving of a raven resting on the floor. Although it is closed there doesn't seem to be a lock.\n";
        break;

        case "open chest":
        chestOpen = true;
        output = "As the flat top of the chest creaks open, you find a pack of matches at its bottom.\n";
        break;


        case "get matches":
        if (chestOpen){
        hasMatches= true;
        output = "You pocket the pack of matches from the chest.\n";
        }
        else {
        output= "There doesn't seem to be any matches around... Try looking around some more.\n";
        }
        break;

        case "light candle":
        if (hasMatches) {
        candleLit = true;
        DoorLocked2 = false;
        output = "You light the candle with a match. Suddenly, the runes along the wax of the candle brighten as its flame flickers. You feel a strong gust behind you that seems to make the candle blow brighter. You hear a loud metal CLICK coming from the direction of the door.\n";
        }
        else {
        output = "You cannot light the candle without a match or tinder.\n";
        }
        break;

        case "look door":
        if (!DoorLocked2) {
        if (DoorOpen2) {
        output = "The black iron door to the north is unlocked and open.\n";
        }
        else {
        output = "The black iron door to the north is unlocked, but it's closed.\n";
        }
        }
        else {
        output = "The black iron door to the north is locked\n";
        }
        break;

        case "open door":
        if (!DoorLocked2) {
        DoorOpen2 = true;
        output = "The door has been opened.\n";
        }
        break;

        case "go north":
        if (DoorOpen2) {
        inFoyer = false;
        inLibrary = true;
        output = "You exit the foyer, and the door slams loudly behind you with a CLICK. It doesn't seem to be openable again.\n You now find yourself in a small library with a single shelf of books. There is a mahogany desk in the center of the room. Although it seems like the desk is meant for studying, there are large scratch marks running along it and its corners have been gnawed off.\n There lies a pen and scroll on top of it.\n To your north, there is a similar caste iron door with a copper knocker. It seems to have different symbols engraved into it.\n";
        }
        break;

        case "go south":
        output = "Wrong direction! Try again.\n";
        break;

        case "go east":
        output = "Wrong direction! Try again.\n";
        break;

        case "go west":
        output = "Wrong direction! Try again.\n";
        break;

        default:
        output = "In the foyer there is a bench, a chest, an unlit candle, and a note. There is a locked door to the north.\n";
        }
        }


        public static void library() {
        System.out.printf("\n%sYou have %d turns left.\n>>", output, turns);
        scan = new Scanner(System.in);
        String testLibrary = scan.nextLine();

        switch (testLibrary) {
        case "help":
        output = "Verbs are open, close, light, read, write, play, look, get. Nouns are door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock. Directions are north, south, east, west. Good luck!\n";
        break;

        case "look":
        output = "You exit the foyer, and the door slams loudly behind you with a CLICK. It doesn't seem to be openable again.\nYou now find yourself in a small library with a single shelf of books. There is a mahogany desk in the center of the room. Although it seems like the desk is meant for studying, there are large scratch marks running along it and its corners have been gnawed off.\nThere lies a pen and scroll on top of it.\nTo your north, there is a similar caste iron door with a copper knocker. It seems to have different symbols engraved into it.\n";
        break;

        case "look shelves":
        output= "When you search the bookshelf, you see an open book with the markings of a wolf. It is titled \"The Autobiography of...\" with the rest of the title missing.\n";
        break;

        case "look shelf":
        output= "When you search the bookshelf, you see an open book with the markings of a wolf of the shelf. It is titled \"The Autobiography of...\" with the rest of the title missing.\n";
        break;

        case "look book":
        output= "You see an open book with the markings of a wolf. It is titled \"The Autobiography of...\" with the rest of the title missing.\n";
        break;

        case "look pen":
            output= "You see a slick black fountain pain with a red ink streak along its side.\n";
            break;


        case "look scroll":
            output= "You see an open book with the markings of a wolf of the shelf. It is titled \"The Autobiography of...\" with the rest of the title missing.\n";
            break;


            case "get pen":
        getPen = true;
        output = "You picked up the pen from the desk.\n It's leaking a little bit of ink\n";
        break;

        case "read scroll":
        output = "You unravel the scroll. It says \"Share your story\" .\n";
        break;

        case "write book":
        writeBook = true;
        DoorLocked3 = false;
        output = "You have completed the autobiography! You then hear a loud CLICK from your north.\n";
        break;

        case "look door":
        if (!DoorLocked3) {
        if (DoorOpen3) {
        output = "The iron door to the north is unlocked and open.\n";
        }
        else {
        output = "The iron door to the north is unlocked, but it's closed.\n";
        }
        }
        else {
        output = "The iron door to the north is locked \n";
        }
        break;

        case "open door":
        if (!DoorLocked3) {
        DoorOpen3 = true;
        output = "The door has been opened.\n";
        }
        break;

        case "go north":
        if (DoorOpen3) {
        inLibrary = false;
        inConservatory = true;
        output = "As you leave the small study, and the door slams loudly behind and then resounds with a loud CLICK. It seems to have locked automatically, so you cannot return to the library.\n You now find yourself in the large conservatory. There is another black to your north. It has a platinum knocker and the unmistakable symbol of the Baron's sigil.\n There are several broken down instruments. The only three that seem to function are a grand piano with a red velvet bench, and silvered trumpet, and a set of bongo drums with a taut skin. \n There's also a stand with sheet music in the center of the room.\n";
        }
        break;

        case "go south":
        output = "Wrong direction! Try again.\n";
        break;

        case "go east":
        output = "Wrong direction! Try again.\n";
        break;

        case "go west":
        output = "Wrong direction! Try again.\n";
        break;

        default:
        output = "In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.\n";
        }
        }

        public static void conservatory()  {
        System.out.printf("\n%s You have %d turns left.\n>>", output, turns);
        scan = new Scanner(System.in);
        String testConservatory = scan.nextLine();

        switch (testConservatory) {
        case "help":
        output = "Verbs are open, close, light, read, write, play, look, get. Nouns are door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock. Directions are north, south, east, west. Good luck!\n";
        break;

        case "look music":
        output= "The sheet music is empty, but there is something written its title.\n";
        break;

        case "read music":
        output = "You read the title as: \"Timbre, Tone, and Time\", although its hard to make out with the scrawly hand writting.\n";
        break;

        case "get trumpet":
        trumpetAcquired= true;
        output = "The trumpet has a snake engraved into it.\n";
        break;

        case "play trumpet":
        if (!playPiano && !playDrum) {
        playTrumpet = true;
        output = "With a triumphant TOOT, the trumpet plays.\n";
        }

        break;


        case "go piano":
        output = "The piano bench's cushion is kind of squishy\n";
        break;

        case "play piano":
        if (playTrumpet && !playDrum && !playPiano) {
        playPiano = true;
        output = "You play the piano Goonies style, it seems to be very out of tune.\n";
        }
        else {
        playPiano = false;
        output = "I guess the stars haven't aligned...\n";
        }
        break;


        case "go drum":
        output = "the drum's skin is coarse and uncomfortable to touch.\n";
        break;

        case "play drum":
        if (playTrumpet && playPiano) {
        playDrum = true;
        output = "Once you lightly tap on the drum, you feel the room quake suddenly and a CLICK resounds from the door.\n";
        }
        else {
        output = "Nothing happened... You better hurry up before time runs out!\n";
        }
        break;

        case "go door":
        output = "You go to the door";
        break;

        case "open door":
        if (DoorLocked4 == true) {
            output = "It's locked";
        }
        else {
            output = "You see light trickle from the outside as you slowly push the heavy black iron door open.";
            DoorOpen4 = true;
        }
        break;

        case "go north":
       if (DoorOpen4) {
           wentDoor = true;

       }
       else {
           output = "You can't";
       }
       break;


        default:
        output = "In the conservatory there is a large door to the north that is locked. There are three instruments- a trumpet, a piano, and a drum. There is a sheet of music on a stand.\n";
        }
        if (playTrumpet && playPiano && playDrum) {
            DoorLocked4 = false;
        }
        }
        }
