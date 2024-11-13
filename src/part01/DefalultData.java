package part01;

import java.util.ArrayList;

public class DefalultData {
    private static ArrayList<Artifact> artifcats = new ArrayList<Artifact>();
    private static ArrayList<Exhibit> exhibits = new ArrayList<Exhibit>();

    /**
     * Created by ChatGPT
     * Version: GPT-4o
     * Used to Create the large test data
     */
    private static String[][] artifactData = {
            { "Rosetta Stone", "Stone", "101", "An ancient Egyptian artifact key to deciphering hieroglyphs." },
            { "Elgin Marbles", "Relief", "102", "A collection of classical Greek marble sculptures." },
            { "Sutton Hoo Helmet", "Helmet", "103", "An Anglo-Saxon helmet from the Sutton Hoo burial site." },
            { "Egyptian Mummy", "Mummy", "104", "A preserved body from ancient Egypt." },
            { "Assyrian Relief", "Relief", "105", "Depicts scenes from Assyrian life and mythology." },
            { "Lewis Chessmen", "Chess Piece", "106", "Medieval chess pieces carved from walrus ivory." },
            { "Roman Coin", "Coin", "107", "Ancient coin used in the Roman Empire." },
            { "Japanese Samurai Armor", "Armor", "108", "Traditional armor worn by Japanese samurai warriors." },
            { "Maya Codex", "Codex", "109", "An ancient Maya manuscript." },
            { "Greek Vase", "Vase", "110", "A decorated vase from ancient Greece." },
            { "Chinese Jade Bi", "Jade", "111", "A jade disc used in ancient Chinese rituals." },
            { "Benin Bronze Plaque", "Bronze", "112", "A plaque from the Kingdom of Benin, depicting royal life." },
            { "Persian Pottery", "Pottery", "113", "Decorative pottery from ancient Persia." },
            { "Byzantine Cross", "Cross", "114", "A cross from the Byzantine Empire." },
            { "Aztec Calendar Stone", "Stone", "115", "An Aztec stone depicting their calendar system." },
            { "Nok Terracotta Figure", "Terracotta", "116", "A terracotta figure from the Nok civilization." },
            { "Hittite Seal", "Seal", "117", "An ancient seal from the Hittite Empire." },
            { "Egyptian Sarcophagus", "Sarcophagus", "118", "A stone coffin from ancient Egypt." },
            { "Viking Sword", "Sword", "119", "A sword used by Viking warriors." },
            { "Ming Vase", "Vase", "120", "A vase from the Ming Dynasty in China." },
            { "Roman Bust", "Bust", "121", "A marble bust of a Roman emperor." },
            { "Babylonian Tablet", "Tablet", "122", "A clay tablet inscribed with cuneiform writing." },
            { "Egyptian Amulet", "Amulet", "123", "An amulet used for protection in ancient Egypt." },
            { "Sumerian Idol", "Idol", "124", "A small statue used in Sumerian religious rituals." },
            { "Renaissance Painting", "Painting", "125", "A painting from the European Renaissance period." },
            { "Medieval Manuscript", "Manuscript", "126", "A handwritten book from the medieval period." },
            { "Terracotta Army Figure", "Terracotta", "127", "A figure from the Terracotta Army in China." },
            { "Ancient Greek Lyre", "Lyre", "128", "A musical instrument from ancient Greece." },
            { "Phoenician Coin", "Coin", "129", "A coin from the Phoenician civilization." },
            { "Inca Textile", "Textile", "130", "A woven fabric from the Inca Empire." },
            { "Olmec Colossal Head", "Sculpture", "131", "A large stone head sculpted by the Olmecs." },
            { "Islamic Astrolabe", "Astrolabe", "132", "An instrument used for astronomical measurements." },
            { "Renaissance Dagger", "Dagger", "133", "A ceremonial dagger from the Renaissance period." },
            { "Anglo-Saxon Brooch", "Brooch", "134", "A brooch used by Anglo-Saxon nobility." },
            { "Egyptian Scarab", "Scarab", "135", "A beetle-shaped amulet from ancient Egypt." },
            { "African Mask", "Mask", "136", "A mask used in African tribal ceremonies." },
            { "Ancient Lamp", "Lamp", "137", "A lamp used in ancient Greece and Rome." },
            { "Victorian Era Coin", "Coin", "138", "A coin from Victorian England." },
            { "Han Dynasty Urn", "Urn", "139", "An urn from the Han Dynasty in China." },
            { "Chinese Scroll", "Scroll", "140", "A traditional Chinese painted scroll." },
            { "Neolithic Axe", "Axe", "141", "A stone axe from the Neolithic era." },
            { "Iron Age Spearhead", "Spearhead", "142", "A spearhead from the Iron Age." },
            { "Roman Mosaic", "Mosaic", "143", "A floor mosaic from ancient Rome." },
            { "Gothic Statue", "Statue", "144", "A statue from the Gothic period." },
            { "Mayan Bowl", "Bowl", "145", "A ceramic bowl from the Maya civilization." },
            { "Sumerian Cylinder Seal", "Seal", "146", "A cylindrical seal used in Sumer." },
            { "Sasanian Silver Plate", "Silver Plate", "147", "A silver plate from the Sasanian Empire." },
            { "Medieval Chalice", "Chalice", "148", "A drinking vessel from the medieval period." },
            { "Inca Quipu", "Quipu", "149", "A recording device used by the Inca civilization." },
            { "Persian Rug", "Rug", "150", "A decorative rug from Persia." },
            { "Islamic Calligraphy", "Calligraphy", "151", "Decorative Islamic calligraphy." },
            { "Indian Bronze Statue", "Bronze", "152", "A bronze statue from ancient India." },
            { "Ming Dynasty Porcelain", "Porcelain", "153", "A porcelain piece from the Ming Dynasty." },
            { "Byzantine Icon", "Icon", "154", "A religious icon from the Byzantine Empire." },
            { "Achaemenid Bracelet", "Bracelet", "155", "A bracelet from the Achaemenid Empire." },
            { "Ancient Harp", "Harp", "156", "A musical instrument from ancient times." },
            { "Venetian Glass", "Glass", "157", "Decorative glass from Venice." },
            { "Egyptian Cartouche", "Cartouche", "158", "A carved nameplate from ancient Egypt." },
            { "Roman Shield", "Shield", "159", "A shield used by Roman soldiers." },
            { "Tang Dynasty Mirror", "Mirror", "160", "A bronze mirror from the Tang Dynasty." },
            { "Minoan Fresco", "Fresco", "161", "A wall painting from ancient Minoan civilization." },
            { "Ancient Greek Coin", "Coin", "162", "A coin used in ancient Greece." },
            { "Celtic Torque", "Jewelry", "163", "A neck ring worn by the ancient Celts." },
            { "Egyptian Papyrus", "Papyrus", "164", "A manuscript made from the papyrus plant." },
            { "Roman Glass Vase", "Vase", "165", "A glass vase from the Roman Empire." },
            { "Indus Valley Seal", "Seal", "166", "An engraved seal from the Indus Valley civilization." },
            { "Mesopotamian Ziggurat Model", "Model", "167", "A model of a Mesopotamian ziggurat temple." },
            { "Ancient Greek Theater Mask", "Mask", "168", "A mask used in Greek theater." },
            { "Egyptian Shabti", "Shabti", "169", "A funerary figurine from ancient Egypt." },
            { "Medieval Armor", "Armor", "170", "Armor worn by medieval knights." },
            { "Phoenician Amphora", "Amphora", "171", "A large vessel used for storing wine or oil." },
            { "Neolithic Pottery", "Pottery", "172", "Pottery from the Neolithic period." },
            { "Roman Bronze Statue", "Statue", "173", "A bronze statue from ancient Rome." },
            { "Hellenistic Coin", "Coin", "174", "A coin from the Hellenistic period." },
            { "Egyptian Funerary Mask", "Mask", "175", "A mask used in Egyptian funerary practices." },
            { "Chinese Dragon Robe", "Clothing", "176", "An ornate robe worn by Chinese royalty." },
            { "Babylonian Cylinder Seal", "Seal", "177", "A small cylindrical seal used in Babylon." },
            { "Ancient Greek Helm", "Helmet", "178", "A helmet used by Greek soldiers." },
            { "Viking Brooch", "Brooch", "179", "A brooch from Viking-era Scandinavia." },
            { "Islamic Tile", "Tile", "180", "A decorative tile from the Islamic world." },
            { "Medieval Crown", "Crown", "181", "A crown worn by European royalty in the medieval period." },
            { "Sumerian Tablet", "Tablet", "182", "A clay tablet with Sumerian writing." },
            { "Persian Vase", "Vase", "183", "A decorated vase from ancient Persia." },
            { "Roman Lamp", "Lamp", "184", "An oil lamp from the Roman Empire." },
            { "Egyptian Coffin", "Coffin", "185", "A decorated coffin from ancient Egypt." },
            { "Byzantine Bracelet", "Bracelet", "186", "A bracelet from the Byzantine Empire." },
            { "Assyrian Bull Statue", "Statue", "187", "A statue depicting an Assyrian bull." },
            { "Ancient Indian Sculpture", "Sculpture", "188", "A sculpture from ancient India." },
            { "Tang Dynasty Horse", "Sculpture", "189", "A ceramic horse statue from the Tang Dynasty." },
            { "Roman Amphora", "Amphora", "190", "A vessel used to store goods in the Roman Empire." },
            { "Ancient Greek Krater", "Vase", "191", "A large Greek vase used for mixing wine." },
            { "Hittite Sword", "Sword", "192", "A ceremonial sword from the Hittite Empire." },
            { "Phoenician Necklace", "Jewelry", "193", "A necklace made by the Phoenicians." },
            { "Egyptian Wall Painting", "Fresco", "194", "A wall painting from an Egyptian tomb." },
            { "Medieval Crossbow", "Weapon", "195", "A crossbow used in medieval Europe." },
            { "Maya Jade Mask", "Mask", "196", "A jade mask from the Maya civilization." },
            { "Greek Amphora", "Amphora", "197", "A pottery vessel used in ancient Greece." },
            { "Egyptian Hieroglyphic Panel", "Panel", "198", "A panel inscribed with Egyptian hieroglyphs." },
            { "Viking Shield", "Shield", "199", "A wooden shield used by Viking warriors." },
            { "Sasanian Helmet", "Helmet", "200", "A helmet from the Sasanian Empire." },
            { "Renaissance Tapestry", "Tapestry", "201", "A decorative tapestry from the Renaissance." },
            { "Assyrian Winged Bull", "Sculpture", "202", "A monumental statue from Assyria." },
            { "Medieval Sword", "Sword", "203", "A sword used by knights in the medieval period." },
            { "Han Dynasty Jade", "Jade", "204", "A jade carving from the Han Dynasty." },
            { "Phoenician Pottery", "Pottery", "205", "Pottery from the Phoenician civilization." },
            { "Inca Gold Ornament", "Ornament", "206", "A gold ornament from the Inca civilization." },
            { "Greek Marble Head", "Sculpture", "207", "A marble head sculpture from ancient Greece." },
            { "Roman Legionnaire Helmet", "Helmet", "208", "A helmet used by Roman legionnaires." },
            { "Chinese Tang Horse", "Statue", "209", "A ceramic horse from the Tang Dynasty." },
            { "Aztec Obsidian Knife", "Knife", "210", "A ceremonial knife made of obsidian by the Aztecs." },
            { "Egyptian Funerary Statue", "Statue", "211", "A statue from an Egyptian burial site." },
            { "Babylonian Kudurru", "Stone", "212", "A boundary stone from ancient Babylon." },
            { "Ancient Greek Stele", "Stele", "213", "A stone slab inscribed with Greek text." },
            { "Persian Archer Figure", "Figure", "214", "A figure of an archer from Persia." },
            { "Byzantine Cross Pendant", "Jewelry", "215", "A cross pendant from the Byzantine period." },
            { "Sumerian Harp", "Harp", "216", "A musical instrument from ancient Sumer." },
            { "Roman Bronze Mirror", "Mirror", "217", "A hand-held mirror from the Roman Empire." },
            { "Egyptian God Statue", "Statue", "218", "A statue depicting an Egyptian deity." },
            { "African Ritual Mask", "Mask", "219", "A mask used in African rituals and ceremonies." },
            { "Islamic Manuscript", "Manuscript", "220", "An illuminated manuscript from the Islamic world." },
            { "Egyptian Obelisk", "Obelisk", "221", "A tall, four-sided monument from ancient Egypt." },
            { "Assyrian Cuneiform Tablet", "Tablet", "222", "A clay tablet inscribed with cuneiform writing." },
            { "Ancient Greek Statue", "Statue", "223", "A statue from classical Greece." },
            { "Viking Ring", "Jewelry", "224", "A decorative ring from the Viking era." },
            { "Mesoamerican Figurine", "Figurine", "225", "A small figurine from Mesoamerica." },
            { "Roman Medical Tools", "Tools", "226", "Surgical tools used in the Roman Empire." },
            { "Etruscan Mirror", "Mirror", "227", "A bronze mirror from the Etruscan civilization." },
            { "Chinese Han Burial Suit", "Suit", "228", "A jade burial suit from the Han Dynasty." },
            { "Greek Gold Necklace", "Jewelry", "229", "A gold necklace from ancient Greece." },
            { "Islamic Ceramics", "Ceramics", "230", "Intricately decorated ceramics from the Islamic world." },
            { "African Tribal Spear", "Spear", "231", "A spear used in African tribal ceremonies." },
            { "Byzantine Coin", "Coin", "232", "A coin from the Byzantine Empire." },
            { "Phoenician Amulet", "Amulet", "233", "An amulet from the Phoenician civilization." },
            { "Inca Ceremonial Knife", "Knife", "234", "A ceremonial knife used by the Inca." },
            { "Tang Dynasty Scroll", "Scroll", "235", "A painted scroll from the Tang Dynasty." },
            { "Ancient Japanese Sword", "Sword", "236", "A sword from ancient Japan." },
            { "Egyptian Ushabti", "Ushabti", "237", "A funerary figurine placed in Egyptian tombs." },
            { "Mughal Empire Dagger", "Dagger", "238", "An ornate dagger from the Mughal Empire." },
            { "Roman Chariot Wheel", "Wheel", "239", "A wheel from a Roman chariot." },
            { "Greek Bronze Shield", "Shield", "240", "A shield used in ancient Greece." },
            { "Chinese Zodiac Statue", "Statue", "241", "A statue representing one of the Chinese zodiac animals." },
            { "Babylonian Relief", "Relief", "242", "A relief sculpture from ancient Babylon." },
            { "Roman Laurel Wreath", "Wreath", "243", "A laurel wreath worn by victorious Romans." },
            { "Nubian Pottery", "Pottery", "244", "Pottery from ancient Nubia." },
            { "Ancient Egyptian Stela", "Stela", "245", "A stone slab inscribed with Egyptian text." },
            { "Islamic Brass Astrolabe", "Astrolabe", "246", "A brass instrument used for navigation." },
            { "Anglo-Saxon Sword", "Sword", "247", "A sword from the Anglo-Saxon period." },
            { "Egyptian Senet Board", "Board Game", "248", "An ancient Egyptian board game." },
            { "Assyrian Winged Genius", "Statue", "249", "A statue depicting a protective spirit from Assyria." },
            { "Roman Fresco", "Fresco", "250", "A wall painting from a Roman villa." },
            { "Medieval Book of Hours", "Manuscript", "251", "A medieval Christian devotional book." },
            { "Greek Bronze Helmet", "Helmet", "252", "A helmet used by Greek soldiers." },
            { "Aztec Shield", "Shield", "253", "A decorative shield from the Aztec civilization." },
            { "Han Dynasty Terra Cotta Soldier", "Statue", "254", "A terra cotta soldier from ancient China." },
            { "Islamic Geometric Tile", "Tile", "255", "A tile with geometric patterns from the Islamic world." },
            { "Roman Oil Lamp", "Lamp", "256", "An oil lamp from ancient Rome." },
            { "Sumerian Plaque", "Plaque", "257", "A clay plaque with Sumerian inscriptions." },
            { "Byzantine Chalice", "Chalice", "258", "A chalice used in Byzantine religious ceremonies." },
            { "Medieval Leather Helmet", "Helmet", "259", "A leather helmet from the medieval period." },
            { "Japanese Noh Mask", "Mask", "260", "A mask used in Japanese Noh theater." },
            { "Maya Stela", "Stela", "261", "A carved stone monument from the Maya civilization." },
            { "Egyptian Canopic Jar", "Jar", "262", "A jar used to store organs in ancient Egypt." },
            { "Inca Silver Llama", "Sculpture", "263", "A small silver llama figure from the Inca Empire." },
            { "Ancient Chinese Bronze Bell", "Bell", "264", "A ceremonial bell from ancient China." },
            { "Mesopotamian Idol", "Idol", "265", "A statue used in Mesopotamian religious rituals." },
            { "Greek Kylix", "Cup", "266", "A drinking cup used in ancient Greece." },
            { "Roman Gladiator Helmet", "Helmet", "267", "A helmet worn by Roman gladiators." },
            { "Hittite Figurine", "Figurine", "268", "A figurine from the Hittite civilization." },
            { "Renaissance Brass Compass", "Compass", "269", "A brass compass used during the Renaissance." },
            { "Egyptian Sphinx Statue", "Statue", "270", "A small statue depicting the Sphinx." },
            { "Phoenician Glass Bead", "Jewelry", "271", "A glass bead made by the Phoenicians." },
            { "Edo Bronze Head", "Bronze", "272", "A bronze head sculpture from the Kingdom of Benin." },
            { "Ancient Greek Fibula", "Jewelry", "273", "A brooch used in ancient Greece." },
            { "Roman Bath Mosaic", "Mosaic", "274", "A floor mosaic from a Roman bath." },
            { "Chinese Qing Vase", "Vase", "275", "A decorative vase from the Qing Dynasty." },
            { "Islamic Brass Lamp", "Lamp", "276", "A brass oil lamp from the Islamic world." },
            { "Byzantine Ivory Icon", "Icon", "277", "An ivory icon from the Byzantine Empire." },
            { "Persian Archer Statue", "Statue", "278", "A small statue of a Persian archer." },
            { "African Copper Bracelet", "Jewelry", "279", "A bracelet made of copper from Africa." },
            { "Viking Boat Model", "Model", "280", "A model of a Viking boat." }
    };

    /**
     * Created by ChatGPT
     * Version: GPT-4o
     * Used to Create the large test data
     */
    private static String[] exhibitNames = {
        "Ancient Egyptian Artifacts",
        "Ancient Greek Artifacts",
        "Babylonian Artifacts",
        "Persian Artifacts",
        "Assyrian Artifacts",
        "Phoenician Artifacts",
        "Ancient Chinese Artifacts",
        "Japanese Artifacts",
        "Viking Artifacts",
        "Mesoamerican (Maya) Artifacts",
        "Aztec Artifacts",
        "Inca and Andean Artifacts",
        "Islamic Artifacts",
        "African Tribal Artifacts",
        "Indian Artifacts",
        "Buddhist Artifacts",
        "Masks and Face Adornments",
        "Pottery and Vases",
        "Bronze Artifacts",
        "Iron Age Artifacts",
        "Ceramics and Porcelain",
        "Burial and Funerary Artifacts",
        "Weapons (Swords, Daggers, Spears)",
        "Helmets and Armor",
        "Sculptures and Statues",
        "Royal and Regal Artifacts",
        "Religious and Ritual Artifacts",
        "Textiles and Fabrics",
        "Jewelry and Decorative Items",
        "Tapestries and Woven Items",
        "Scrolls and Manuscripts",
        "Coins and Currency",
        "Paintings and Frescoes",
        "Navigation and Astronomical Instruments",
        "Medical and Tools",
        "Maps and Geographic Artifacts"
    };

    private static ArrayList<ArrayList<Integer>> exhibitArtifacts = new ArrayList<>();;
    private static ArrayList<ArrayList<String>> exhibitRoutes = new ArrayList<>();;

    /**
     * Created by ChatGPT
     * Version: GPT-4o
     * Used to Create the large test data
     */
    private static void createAllExhibitData() {
        // Initialize 36 themes (ArrayLists) to categorize similar artifacts by their indexes
        for (int i = 0; i < 36; i++) {
            exhibitArtifacts.add(new ArrayList<Integer>());
            exhibitRoutes.add(new ArrayList<String>());
        }
        
        // Group artifacts into 36 unique thematic sets
        for (int i = 0; i < artifactData.length; i++) {
            String artifactName = artifactData[i][0];
            String artifactDescription = artifactData[i][3];
            
            // Assign artifacts to specific unique themes based on name and description
            if (artifactDescription.contains("Egypt") || artifactName.contains("Egypt")) {
                exhibitArtifacts.get(0).add(i); // Ancient Egyptian Artifacts
                exhibitRoutes.get(0).add(artifactDescription);
            } else if (artifactDescription.contains("Greece") || artifactName.contains("Greek")) {
                exhibitArtifacts.get(1).add(i); // Ancient Greek Artifacts
                exhibitRoutes.get(1).add(artifactDescription);
            } else if (artifactDescription.contains("Babylon") || artifactName.contains("Babylon")) {
                exhibitArtifacts.get(2).add(i); // Babylonian Artifacts
                exhibitRoutes.get(2).add(artifactDescription);
            } else if (artifactDescription.contains("Persia") || artifactDescription.contains("Persian")) {
                exhibitArtifacts.get(3).add(i); // Persian Artifacts
                exhibitRoutes.get(3).add(artifactDescription);
            } else if (artifactDescription.contains("Assyrian") || artifactName.contains("Assyria")) {
                exhibitArtifacts.get(4).add(i); // Assyrian Artifacts
                exhibitRoutes.get(4).add(artifactDescription);
            } else if (artifactDescription.contains("Phoenician") || artifactName.contains("Phoenician")) {
                exhibitArtifacts.get(5).add(i); // Phoenician Artifacts
                exhibitRoutes.get(5).add(artifactDescription);
            } else if (artifactDescription.contains("China") || artifactName.contains("Chinese")) {
                exhibitArtifacts.get(6).add(i); // Ancient Chinese Artifacts
                exhibitRoutes.get(6).add(artifactDescription);
            } else if (artifactDescription.contains("Japan") || artifactName.contains("Japanese")) {
                exhibitArtifacts.get(7).add(i); // Japanese Artifacts
                exhibitRoutes.get(7).add(artifactDescription);
            } else if (artifactDescription.contains("Viking") || artifactName.contains("Norse")) {
                exhibitArtifacts.get(8).add(i); // Viking Artifacts
                exhibitRoutes.get(8).add(artifactDescription);
            } else if (artifactDescription.contains("Maya") || artifactDescription.contains("Mesoamerica")) {
                exhibitArtifacts.get(9).add(i); // Mesoamerican (Maya) Artifacts
                exhibitRoutes.get(9).add(artifactDescription);
            } else if (artifactDescription.contains("Aztec") || artifactDescription.contains("Mexican")) {
                exhibitArtifacts.get(10).add(i); // Aztec Artifacts
                exhibitRoutes.get(10).add(artifactDescription);
            } else if (artifactDescription.contains("Inca") || artifactDescription.contains("Andes")) {
                exhibitArtifacts.get(11).add(i); // Inca and Andean Artifacts
                exhibitRoutes.get(11).add(artifactDescription);
            } else if (artifactDescription.contains("Islamic") || artifactDescription.contains("Muslim")) {
                exhibitArtifacts.get(12).add(i); // Islamic Artifacts
                exhibitRoutes.get(12).add(artifactDescription);
            } else if (artifactDescription.contains("African") || artifactDescription.contains("tribal")) {
                exhibitArtifacts.get(13).add(i); // African Tribal Artifacts
                exhibitRoutes.get(13).add(artifactDescription);
            } else if (artifactDescription.contains("Indian") || artifactDescription.contains("Hindu")) {
                exhibitArtifacts.get(14).add(i); // Indian Artifacts
                exhibitRoutes.get(14).add(artifactDescription);
            } else if (artifactDescription.contains("Buddhist") || artifactDescription.contains("Buddha")) {
                exhibitArtifacts.get(15).add(i); // Buddhist Artifacts
                exhibitRoutes.get(15).add(artifactDescription);
            } else if (artifactDescription.contains("mask")) {
                exhibitArtifacts.get(16).add(i); // Masks and Face Adornments
                exhibitRoutes.get(16).add(artifactDescription);
            } else if (artifactDescription.contains("pottery") || artifactName.contains("Vase")) {
                exhibitArtifacts.get(17).add(i); // Pottery and Vases
                exhibitRoutes.get(17).add(artifactDescription);
            } else if (artifactDescription.contains("bronze") || artifactName.contains("Bronze")) {
                exhibitArtifacts.get(18).add(i); // Bronze Artifacts
                exhibitRoutes.get(18).add(artifactDescription);
            } else if (artifactDescription.contains("iron") || artifactName.contains("Iron")) {
                exhibitArtifacts.get(19).add(i); // Iron Age Artifacts
                exhibitRoutes.get(19).add(artifactDescription);
            } else if (artifactDescription.contains("ceramic") || artifactDescription.contains("porcelain")) {
                exhibitArtifacts.get(20).add(i); // Ceramics and Porcelain
                exhibitRoutes.get(20).add(artifactDescription);
            } else if (artifactDescription.contains("tomb") || artifactDescription.contains("burial")) {
                exhibitArtifacts.get(21).add(i); // Burial and Funerary Artifacts
                exhibitRoutes.get(21).add(artifactDescription);
            } else if (artifactDescription.contains("weapon") || artifactDescription.contains("sword") || artifactDescription.contains("dagger")) {
                exhibitArtifacts.get(22).add(i); // Weapons (Swords, Daggers, Spears)
                exhibitRoutes.get(22).add(artifactDescription);
            } else if (artifactDescription.contains("helmet") || artifactDescription.contains("armor")) {
                exhibitArtifacts.get(23).add(i); // Helmets and Armor
                exhibitRoutes.get(23).add(artifactDescription);
            } else if (artifactDescription.contains("sculpture") || artifactDescription.contains("statue")) {
                exhibitArtifacts.get(24).add(i); // Sculptures and Statues
                exhibitRoutes.get(24).add(artifactDescription);
            } else if (artifactDescription.contains("royal") || artifactDescription.contains("crown") || artifactDescription.contains("regal")) {
                exhibitArtifacts.get(25).add(i); // Royal and Regal Artifacts
                exhibitRoutes.get(25).add(artifactDescription);
            } else if (artifactDescription.contains("religious") || artifactDescription.contains("ritual")) {
                exhibitArtifacts.get(26).add(i); // Religious and Ritual Artifacts
                exhibitRoutes.get(26).add(artifactDescription);
            } else if (artifactDescription.contains("textile") || artifactDescription.contains("cloth")) {
                exhibitArtifacts.get(27).add(i); // Textiles and Fabrics
                exhibitRoutes.get(27).add(artifactDescription);
            } else if (artifactDescription.contains("jewelry") || artifactName.contains("Jewelry") || artifactDescription.contains("ornament")) {
                exhibitArtifacts.get(28).add(i); // Jewelry and Decorative Items
                exhibitRoutes.get(28).add(artifactDescription);
            } else if (artifactDescription.contains("tapestry") || artifactDescription.contains("woven")) {
                exhibitArtifacts.get(29).add(i); // Tapestries and Woven Items
                exhibitRoutes.get(29).add(artifactDescription);
            } else if (artifactDescription.contains("scroll") || artifactDescription.contains("manuscript")) {
                exhibitArtifacts.get(30).add(i); // Scrolls and Manuscripts
                exhibitRoutes.get(30).add(artifactDescription);
            } else if (artifactDescription.contains("coin") || artifactDescription.contains("currency")) {
                exhibitArtifacts.get(31).add(i); // Coins and Currency
                exhibitRoutes.get(31).add(artifactDescription);
            } else if (artifactDescription.contains("painting") || artifactDescription.contains("fresco")) {
                exhibitArtifacts.get(32).add(i); // Paintings and Frescoes
                exhibitRoutes.get(32).add(artifactDescription);
            } else if (artifactDescription.contains("navigation") || artifactDescription.contains("astrolabe")) {
                exhibitArtifacts.get(33).add(i); // Navigation and Astronomical Instruments
                exhibitRoutes.get(33).add(artifactDescription);
            } else if (artifactDescription.contains("medical") || artifactDescription.contains("tool")) {
                exhibitArtifacts.get(34).add(i); // Medical and Tools
                exhibitRoutes.get(34).add(artifactDescription);
            } else if (artifactDescription.contains("map") || artifactDescription.contains("chart")) {
                exhibitArtifacts.get(35).add(i); // Maps and Geographic Artifacts
                exhibitRoutes.get(35).add(artifactDescription);
            }
        }
    }

    private static Artifact createArtifact(String name, String Type, int engagementTime) {
        try {
            return new Artifact(name, Type, engagementTime);
        } catch (Exception e) {
            System.out.println("Bad Data");
            return null;
        }
    }

    private static Exhibit createExhibit(String name, ArrayList<Integer> artifactsID, ArrayList<String> route) {
        try {
            return new Exhibit(name, artifactsID, route);
        } catch (Exception e) {
            System.out.println("Bad Data");
            return null;
        }
    }

    public static ArrayList<Artifact> populateArtifacts() {
        for (int i = 0; i < artifactData.length; i++) {
            Artifact artifact = createArtifact(artifactData[i][0], artifactData[i][1],
                    Integer.valueOf(artifactData[i][2]));
            artifcats.add(artifact);
        }
        return artifcats;
    }

    public static ArrayList<Exhibit> populateExhibits() {
        createAllExhibitData();
        for (int i = 0; i < exhibitNames.length; i++) {
            Exhibit exhibit = createExhibit(exhibitNames[i], exhibitArtifacts.get(i), exhibitRoutes.get(i));
            exhibits.add(exhibit);
        }
        return exhibits;
    }

    public static int[][] populateExhibitionPlan() {
        int[][] exhibitionPlan = new int[12][3];
        int k = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                exhibitionPlan[i][j] = k;
                k++;
            }
        }
        return exhibitionPlan;
    }
}
