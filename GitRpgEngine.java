import java.util.*;

public class GitRpgEngine {
    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        
        // Help Menu
        if (argList.contains("--help") || args.length == 0) {
            printManual();
            return;
        }

        // Extract parameters
        int actionIdx = argList.indexOf("--action");
        int heroClassIdx = argList.indexOf("--class");
        int targetIdx = argList.indexOf("--target");

        if (actionIdx == -1 || actionIdx + 1 >= args.length) {
            System.err.println("Error: Missing --action parameter!");
            System.exit(1);
        }

        String action = args[actionIdx + 1].toLowerCase();
        String heroClass = (heroClassIdx != -1 && heroClassIdx + 1 < args.length) ? args[heroClassIdx + 1] : "Warrior";
        String target = (targetIdx != -1 && targetIdx + 1 < args.length) ? args[targetIdx + 1] : "Merge Conflict Slime";

        // Game State Core Mocking
        Random rng = new Random();
        int baseDmg = switch (heroClass.toLowerCase()) {
            case "wizard" -> rng.nextInt(15) + 20; // High swing math
            case "rogue" -> rng.nextInt(5) + 15;  // Crit candidate
            default -> 12; // Steady warrior output
        };

        boolean isCrit = (heroClass.equalsIgnoreCase("rogue") && rng.nextInt(100) < 40) || rng.nextInt(100) < 10;
        if (isCrit) baseDmg *= 2;

        // Terminal Action Kernel Processor
        System.out.println("==========================================================================");
        System.out.println("⚔️  GITRPG ENGINE ENGINE MAIN LOG // TRANSACTION ONLINE");
        System.out.println("==========================================================================");
        
        switch (action) {
            case "attack" -> {
                System.out.println("🎮 ACTION: A wild " + heroClass + " approaches the terminal!");
                System.out.println("⚔️ STATUS: Swung a mighty compiler exception at [" + target + "]!");
                if (isCrit) System.out.println("🔥 CRITICAL HIT! The source code fragmented!");
                System.out.println("💥 DAMAGE DEALER: " + baseDmg + " structural damage recorded.");
            }
            case "heal" -> {
                int healValue = rng.nextInt(10) + 10;
                System.out.println("🧪 ACTION: Chugging a fresh hot cup of Java primitive data nodes...");
                System.out.println("💚 RECOVERY: Patched up " + healValue + " structural integrity segments!");
            }
            case "scan" -> {
                System.out.println("🕵️ ACTION: Scanning memory nodes for boss vulnerability...");
                System.out.println("📊 METRICS: [" + target + "] is currently weak to StackOverflow anomalies!");
            }
            default -> {
                System.err.println("Error: Inversion code sequencing failure. Unknown attack pattern.");
                System.exit(1);
            }
        }
        System.out.println("==========================================================================");
    }

    private static void printManual() {
        System.out.println("GitRPG Terminal Engine Manual");
        System.out.println("Usage: java GitRpgEngine --action [attack|heal|scan] --class [Warrior|Wizard|Rogue]");
    }
}
