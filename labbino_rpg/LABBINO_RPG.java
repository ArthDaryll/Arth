package labbino_rpg;
import java.util.Scanner;

public class LABBINO_RPG {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase;
        System.out.println("Enter test case number: ");
        testCase = scanner.nextInt();
        
        Character character = new Character(100, 20, 5);
        Swordsman swordsman = new Swordsman(100, 10, 10);
        Paladin paladin = new Paladin(100, 10, 10);
        int paladinReceive = 110; //pang testing
        
        switch (testCase) {
            case 1: System.out.println("Testing Character Private Fields");
            testFieldPrivacy(character);
            break;
            case 2: System.out.println("Testing Character class getters");
            System.out.println("Character - Health: "+character.getHealth());
            System.out.println("Character - Damage: "+character.getDamage());
            System.out.println("Character - Shield: "+character.getShield());
            break;
            case 3: System.out.println("Test Swordsman class getters");
            System.out.println("Character - Health: "+swordsman.getHealth());
            System.out.println("Character - Damage: "+swordsman.getDamage());
            System.out.println("Character - Shield: "+swordsman.getShield());
            break;
            case 4: System.out.println("Testing Paladin Private Fields");
            testFieldPrivacy(paladin);
            break;
            case 5: System.out.println("Testing Paladin class getters");
            System.out.println("Character - Health: "+paladin.getHealth());
            System.out.println("Character - Damage: "+paladin.getDamage());
            System.out.println("Character - Shield: "+paladin.getShield());
            break;
            case 6: System.out.println("Testing damage received for all");
            character.receiveDamage(20);
            System.out.println("Character after receiving damage: "+character.getHealth());
            swordsman.receiveDamage(10);
            System.out.println("Swordsman after receiving damage: "+swordsman.getHealth());
            swordsman.receiveDamage(10);
            System.out.println("Paladin after receiving damage: "+paladin.getHealth());
            break;
            case 7: System.out.println("Testing resurrection for Paladin");
                paladin.receiveDamage(paladinReceive);
                System.out.println("Paladin after receiving "+paladinReceive+" damage - Health: " + paladin.getHealth());
                paladin.resurrect();
                System.out.println("Paladin after resurrecting - Health: " + paladin.getHealth());
                break;
            case 8: System.out.println("Testing if Swordsman is a child of Character");
                if (swordsman instanceof Character) {
                    System.out.println("Swordsman is a child of Character");
                } else {
                    System.out.println("Swordsman is not a child of Character");
                }
        
                System.out.println();
                break;
            case 9: System.out.println("Testing if Paladin is a child of Character");
                    if (paladin instanceof Character) {
                        System.out.println("Paladin is a child of Character");
                    } else {
                        System.out.println("Paladin is not a child of Character");
                    }
                break;

            default:
                System.out.println("Invalid test case number.");
                break;
    } scanner.close();
        
    }
    public static void testFieldPrivacy (Character character){
        Class<?> cl = character.getClass();
        java.lang.reflect.Field[] fields = cl.getDeclaredFields();
        boolean allFieldsPrivate = true;
        
        for (java.lang.reflect.Field field : fields){
            if (!java.lang.reflect.Modifier.isPrivate(field.getModifiers())) {
                allFieldsPrivate = false;
                System.out.println("Field '" + field.getName() + "' is not private");
            }
        }
        if (allFieldsPrivate){
            System.out.println("All fields are private");
        } else {
            System.out.println("Not all fields are private");
        }
        
    }
    
}
