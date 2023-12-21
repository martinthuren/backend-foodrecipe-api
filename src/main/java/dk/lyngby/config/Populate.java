package dk.lyngby.config;


import dk.lyngby.model.Recipe;
import jakarta.persistence.EntityManagerFactory;
import org.jetbrains.annotations.NotNull;
import java.math.BigDecimal;
import java.util.Set;

public class Populate {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Recipe ProteinOatmeal = new Recipe(
                    "Protein Oatmeal",
                    "https://i.imgur.com/rE2HvUH.jpg",
                    Recipe.RecipeType.BREAKFAST,
                    "A delicious and healthy breakfast",
                    10,
                    "1/2 cup oats, 1 cup milk, 1 scoop protein powder, 1/2 cup berries",
                    "Mix oats and milk in a bowl\nMicrowave for 2 minutes\nAdd protein powder and berries"
            );

            Recipe ProteinPizza = new Recipe(
                    "Protein Pizza",
                    "https://i.imgur.com/BgFv23l.jpg",
                    Recipe.RecipeType.DINNER,
                    "A delicious and healthy dinner",
                    30,
                    "1/2 cup oats, 1 cup milk, 1 scoop protein powder, 1/2 cup berries",
                    "Mix oats and milk in a bowl\nMicrowave for 2 minutes\nAdd protein powder and berries"
            );

            Recipe VeggieStirFry = new Recipe(
                    "Veggie Stir-Fry",
                    "https://i.imgur.com/Vs4kvN6.jpg",
                    Recipe.RecipeType.DINNER,
                    "A flavorful vegetarian dinner",
                    25,
                    "2 cups mixed vegetables, 1 cup tofu, 2 tbsp soy sauce, 1 tbsp oil",
                    "Heat oil in a pan\nAdd vegetables and tofu, stir-fry for 10 minutes\nAdd soy sauce and cook for another 5 minutes"
            );

            Recipe FruitSalad = new Recipe(
                    "Fruit Salad",
                    "https://i.imgur.com/Li12hJN.jpg",
                    Recipe.RecipeType.SNACK,
                    "A refreshing and healthy snack",
                    15,
                    "2 apples, 2 bananas, 1 cup grapes, 1/2 cup nuts, honey (optional)",
                    "Chop fruits and mix in a bowl\nAdd nuts and drizzle honey if desired"
            );

            Recipe ChickenQuinoaBowl = new Recipe(
                    "Chicken Quinoa Bowl",
                    "https://i.imgur.com/3xTqcKa.jpg",
                    Recipe.RecipeType.LUNCH,
                    "A protein-packed lunch option",
                    35,
                    "1 cup quinoa, 1 chicken breast, 1 cup broccoli, 1 tbsp olive oil, spices",
                    "Cook quinoa as per instructions\nGrill chicken and chop into pieces\nSteam broccoli\nMix all ingredients and add spices"
            );

            Recipe AvocadoToast = new Recipe(
                    "Avocado Toast",
                    "https://i.imgur.com/Aa6xYHy.jpg",
                    Recipe.RecipeType.BREAKFAST,
                    "A trendy and nutritious breakfast",
                    15,
                    "2 slices whole grain bread, 1 ripe avocado, salt, pepper, red pepper flakes (optional)",
                    "Toast bread slices\nMash avocado and spread on toast\nSprinkle salt, pepper, and red pepper flakes"
            );

            Recipe LentilSoup = new Recipe(
                    "Lentil Soup",
                    "https://i.imgur.com/asol2Yu.jpg",
                    Recipe.RecipeType.DINNER,
                    "A hearty and comforting soup",
                    40,
                    "1 cup lentils, 2 carrots, 2 celery stalks, 1 onion, 4 cups vegetable broth, spices",
                    "Chop vegetables\nSauté veggies in a pot\nAdd lentils, broth, and spices\nSimmer for 30 minutes"
            );

            Recipe TofuScramble = new Recipe(
                    "Tofu Scramble",
                    "https://i.imgur.com/mdUM742.jpg",
                    Recipe.RecipeType.BREAKFAST,
                    "A vegan alternative to scrambled eggs",
                    20,
                    "1 block tofu, 1 bell pepper, 1 onion, 2 tbsp nutritional yeast, spices",
                    "Crumble tofu in a pan\nSauté chopped pepper and onion\nAdd tofu, nutritional yeast, and spices"
            );

            Recipe YogurtParfait = new Recipe(
                    "Greek Yogurt Parfait",
                    "https://i.imgur.com/IE4QxQ3.jpg",
                    Recipe.RecipeType.SNACK,
                    "A healthy and customizable snack",
                    10,
                    "1 cup Greek yogurt, 1/2 cup granola, 1/2 cup mixed berries, honey (optional)",
                    "Layer yogurt, granola, and berries in a glass\nDrizzle honey if desired"
            );

            Recipe TurkeyVeggieWrap = new Recipe(
                    "Turkey Veggie Wrap",
                    "https://i.imgur.com/jko93Dp.jpg",
                    Recipe.RecipeType.LUNCH,
                    "A quick and nutritious lunch option",
                    15,
                    "4 slices turkey, 1 whole grain wrap, lettuce, tomato, cucumber, hummus",
                    "Spread hummus on wrap\nLayer turkey slices and veggies\nRoll up the wrap"
            );

            Recipe SmoothieBowl = new Recipe(
                    "Smoothie Bowl",
                    "https://i.imgur.com/n3nWFY4.jpg",
                    Recipe.RecipeType.BREAKFAST,
                    "A vibrant and energizing breakfast",
                    10,
                    "1 frozen banana, 1/2 cup mixed berries, 1/2 cup spinach, 1/2 cup almond milk, toppings (granola, sliced fruits, seeds)",
                    "Blend banana, berries, spinach, and almond milk\nPour into a bowl and add toppings"
            );

            Recipe ShrimpBroccoliStirFry = new Recipe(
                    "Shrimp Broccoli Stir-Fry",
                    "https://i.imgur.com/aFyRD6q.jpg",
                    Recipe.RecipeType.DINNER,
                    "A flavorful seafood dinner",
                    20,
                    "1 lb shrimp, 2 cups broccoli florets, 2 garlic cloves, 2 tbsp soy sauce, 1 tbsp sesame oil",
                    "Sauté minced garlic in oil\nAdd shrimp and cook\nAdd broccoli and soy sauce, stir-fry until tender"
            );

            Recipe QuinoaSalad = new Recipe(
                    "Quinoa Salad",
                    "https://i.imgur.com/ZGrAUGk.jpg",
                    Recipe.RecipeType.LUNCH,
                    "A refreshing and protein-rich salad",
                    25,
                    "1 cup quinoa, 1 cucumber, 1 bell pepper, cherry tomatoes, feta cheese, dressing",
                    "Cook quinoa as per instructions\nChop veggies and mix with quinoa\nAdd feta cheese and dressing"
            );

            Recipe BlueberryPancakes = new Recipe(
                    "Blueberry Pancakes",
                    "https://i.imgur.com/4vtbitl.jpg",
                    Recipe.RecipeType.BREAKFAST,
                    "Delicious fluffy pancakes with a burst of blueberries",
                    20,
                    "1 cup flour, 1 tbsp sugar, 1 tsp baking powder, 1 egg, 1 cup milk, 1/2 cup blueberries",
                    "Mix dry ingredients in a bowl\nIn another bowl, whisk egg and milk\nCombine wet and dry ingredients\nFold in blueberries\nCook pancakes on a griddle"
            );

            Recipe GrilledVeggieSandwich = new Recipe(
                    "Grilled Vegetable Sandwich",
                    "https://i.imgur.com/rq6i3ug.jpg",
                    Recipe.RecipeType.LUNCH,
                    "A hearty sandwich filled with grilled veggies",
                    25,
                    "Assorted vegetables (zucchini, bell peppers, eggplant), 4 slices whole grain bread, cheese, pesto (optional)",
                    "Slice vegetables and grill them\nToast bread slices\nLayer vegetables and cheese between bread\nSpread pesto if desired"
            );

            Recipe BakedSalmonRoastedVeggies = new Recipe(
                    "Baked Salmon with Roasted Vegetables",
                    "https://i.imgur.com/8kyvy5H.jpg",
                    Recipe.RecipeType.DINNER,
                    "A nutritious and flavorful dinner option",
                    35,
                    "4 salmon fillets, assorted vegetables (carrots, potatoes, broccoli), olive oil, herbs",
                    "Preheat oven\nSeason salmon with herbs\nChop veggies and toss with oil\nBake salmon and veggies in the oven"
            );

            Recipe BananaNutOvernightOats = new Recipe(
                    "Banana Nut Overnight Oats",
                    "https://i.imgur.com/TiIZ5pc.jpg",
                    Recipe.RecipeType.BREAKFAST,
                    "Prepare ahead for a quick morning meal",
                    10,
                    "1/2 cup oats, 1/2 cup milk, 1 banana, 1 tbsp peanut butter, 1 tbsp honey, 1 tbsp nuts",
                    "Mash banana in a bowl\nAdd oats, milk, peanut butter, and honey\nMix well and refrigerate overnight\nTop with nuts before serving"
            );

            Recipe ChickpeaSalad = new Recipe(
                    "Chickpea Salad",
                    "https://i.imgur.com/tbMGbCo.jpg",
                    Recipe.RecipeType.LUNCH,
                    "A protein-packed and refreshing salad",
                    20,
                    "1 can chickpeas, cucumber, cherry tomatoes, red onion, feta cheese, lemon vinaigrette",
                    "Rinse and drain chickpeas\nChop veggies and mix with chickpeas\nAdd feta cheese and dress with lemon vinaigrette"
            );

            Recipe EggplantParmesan = new Recipe(
                    "Eggplant Parmesan",
                    "https://i.imgur.com/9zUv5xQ.jpg",
                    Recipe.RecipeType.DINNER,
                    "A satisfying vegetarian Italian dish",
                    50,
                    "2 eggplants, breadcrumbs, marinara sauce, mozzarella cheese, parmesan cheese, herbs",
                    "Slice eggplants and coat with breadcrumbs\nBake until golden\nLayer with marinara and cheeses\nBake until cheese melts"
            );

            Recipe GreenSmoothie = new Recipe(
                    "Green Smoothie",
                    "https://i.imgur.com/EU0GoRT.jpg",
                    Recipe.RecipeType.SNACK,
                    "A nutritious and refreshing drink",
                    10,
                    "2 cups spinach, 1 banana, 1/2 avocado, 1 cup almond milk, honey (optional)",
                    "Blend spinach, banana, avocado, and almond milk\nSweeten with honey if desired"
            );

            Recipe TunaSaladWrap = new Recipe(
                    "Tuna Salad Wrap",
                    "https://i.imgur.com/bt5oYrb.jpg",
                    Recipe.RecipeType.LUNCH,
                    "A simple and protein-rich lunch option",
                    15,
                    "1 can tuna, lettuce, tomato, onion, whole grain wrap, Greek yogurt (or mayo)",
                    "Mix tuna with Greek yogurt (or mayo)\nSpread on wrap and add veggies\nRoll up the wrap"
            );

            Recipe VeggieFrittata = new Recipe(
                    "Veggie Frittata",
                    "https://i.imgur.com/CfZwPNK.jpg",
                    Recipe.RecipeType.BREAKFAST,
                    "A versatile and satisfying breakfast dish",
                    30,
                    "6 eggs, assorted vegetables (bell peppers, spinach, onions), cheese, herbs",
                    "Whisk eggs in a bowl\nSauté veggies in a pan\nPour eggs over veggies, sprinkle cheese and herbs\nBake until set"
            );

            Recipe CaramelBliss = new Recipe(
                    "Caramel Bliss",
                    "https://i.imgur.com/AB3rTgQ.jpg",
                    Recipe.RecipeType.DRINK,
                    "Indulge in the sweet and rich flavors of caramel with this blissful cocktail.",
                    5,
                    "2 oz caramel liqueur, 1 oz vanilla vodka, 1 oz cream, caramel drizzle, ice cubes",
                    "In a shaker, combine caramel liqueur, vanilla vodka, and cream with ice.\n" +
                            "Shake well and strain into a glass filled with ice.\n" +
                            "Drizzle caramel on top for an extra touch of sweetness."
            );

            Recipe coffeeMartini = new Recipe(
                    "Coffee Martini",
                    "https://i.imgur.com/GzkKpcy.jpg",
                    Recipe.RecipeType.DRINK,
                    "A classic martini with a coffee twist, perfect for coffee lovers and cocktail enthusiasts.",
                    5,
                    "2 oz coffee liqueur, 1 oz vodka, 1/2 oz simple syrup, coffee beans, ice cubes",
                    "In a shaker, mix coffee liqueur, vodka, and simple syrup with ice.\n" +
                            "Shake well and strain into a chilled martini glass.\n" +
                            "Garnish with a few coffee beans."
            );

            Recipe lemonDropFizz = new Recipe(
                    "Lemon Drop Fizz",
                    "https://i.imgur.com/mjoHlXD.jpg",
                    Recipe.RecipeType.DRINK,
                    "A sparkling and zesty concoction that combines the brightness of lemon with fizzy delight.",
                    5,
                    "2 oz lemon vodka, 1 oz triple sec, 1 oz lemon juice, soda water, lemon twist, ice cubes",
                    "In a glass, mix lemon vodka, triple sec, and lemon juice with ice.\n" +
                            "Top with soda water and stir gently.\n" +
                            "Garnish with a twist of lemon."
            );

            Recipe lycheeSparkler = new Recipe(
                    "Lychee Sparkler",
                    "https://i.imgur.com/nHx1MK4.jpg",
                    Recipe.RecipeType.DRINK,
                    "Experience the exotic and floral notes of lychee in this refreshing sparkling drink.",
                    5,
                    "2 oz lychee liqueur, 1 oz vodka, 1 oz elderflower liqueur, lychee fruit, ice cubes",
                    "In a shaker, combine lychee liqueur, vodka, and elderflower liqueur with ice.\n" +
                            "Shake well and strain into a glass filled with ice.\n" +
                            "Garnish with a lychee fruit."
            );

            Recipe limeMargarita = new Recipe(
                    "Lime Margarita",
                    "https://i.imgur.com/fHfNmPK.jpg",
                    Recipe.RecipeType.DRINK,
                    "A tangy and refreshing margarita that highlights the citrusy goodness of lime.",
                    5,
                    "2 oz silver tequila, 1 oz triple sec, 1 oz fresh lime juice, salt for rimming, lime wedge, ice cubes",
                    "Rim a glass with salt.\n" +
                            "In a shaker, mix tequila, triple sec, and lime juice with ice.\n" +
                            "Strain into the prepared glass and garnish with a lime wedge."
            );

            Recipe orangeDream = new Recipe(
                    "Orange Dream",
                    "https://i.imgur.com/yhOUJcF.jpg",
                    Recipe.RecipeType.DRINK,
                    "A dreamy and citrusy cocktail featuring the vibrant flavors of orange.",
                    5,
                    "2 oz orange vodka, 1 oz triple sec, 1 oz cream, orange twist, ice cubes",
                    "In a shaker, combine orange vodka, triple sec, and cream with ice.\n" +
                            "Shake well and strain into a glass filled with ice.\n" +
                            "Garnish with an orange twist."
            );

            Recipe passionfruitParadise = new Recipe(
                    "Passionfruit Paradise",
                    "https://i.imgur.com/jM4O6fp.jpg",
                    Recipe.RecipeType.DRINK,
                    "Immerse yourself in the tropical paradise with the intense and fruity flavor of passionfruit.",
                    5,
                    "2 oz passionfruit juice, 1 oz white rum, 1 oz coconut cream, passionfruit seeds, ice cubes",
                    "In a blender, mix passionfruit juice, white rum, and coconut cream with ice.\n" +
                            "Blend until smooth and pour into a glass.\n" +
                            "Garnish with passionfruit seeds."
            );

            Recipe pineapplePunch = new Recipe(
                    "Pineapple Punch",
                    "https://i.imgur.com/z99K3Aa.jpg",
                    Recipe.RecipeType.DRINK,
                    "A punchy and tropical drink that captures the essence of ripe pineapple.",
                    5,
                    "2 oz pineapple juice, 1 oz dark rum, 1 oz coconut water, pineapple wedge, ice cubes",
                    "In a glass, mix pineapple juice, dark rum, and coconut water with ice.\n" +
                            "Stir gently and garnish with a pineapple wedge."
            );

            Recipe strawberryDaiquiri = new Recipe(
                    "Strawberry Daiquiri",
                    "https://i.imgur.com/WHDcHdI.jpg",
                    Recipe.RecipeType.DRINK,
                    "A classic daiquiri with a burst of fresh strawberry sweetness for a delightful twist.",
                    5,
                    "2 oz white rum, 1 oz strawberry puree, 1 oz simple syrup, strawberry slice, ice cubes",
                    "In a shaker, combine white rum, strawberry puree, and simple syrup with ice.\n" +
                            "Shake well and strain into a glass filled with ice.\n" +
                            "Garnish with a strawberry slice."
            );

            Recipe watermelonMintCooler = new Recipe(
                    "Watermelon Mint Cooler",
                    "https://i.imgur.com/qIf8eG5.jpg",
                    Recipe.RecipeType.DRINK,
                    "Stay cool with this refreshing drink featuring the juicy goodness of watermelon and the freshness of mint.",
                    5,
                    "2 oz watermelon juice, 1 oz vodka, 1 oz mint syrup, mint leaves, watermelon cube, ice cubes",
                    "In a glass, mix watermelon juice, vodka, and mint syrup with ice.\n" +
                            "Stir gently and garnish with mint leaves and a watermelon cube."
            );

            Recipe chocolateCake = new Recipe(
                    "Chocolate Cake",
                    "https://i.imgur.com/QnADiI9.jpg",
                    Recipe.RecipeType.DESSERT,
                    "Indulge in the rich flavor of chocolate with this decadent cake.",
                    60,
                    "2 cups all-purpose flour, 1 cup cocoa powder, 1 ½ cups sugar, 2 tsp baking powder, " +
                            "1 tsp baking soda, ½ tsp salt, 1 cup milk, ½ cup vegetable oil, 2 eggs, 2 tsp vanilla extract, " +
                            "1 cup boiling water, chocolate frosting",
                    "1. Preheat oven to 350°F (175°C). Grease and flour two 9-inch round cake pans.\n" +
                            "2. In a large bowl, mix flour, cocoa powder, sugar, baking powder, baking soda, and salt.\n" +
                            "3. Add milk, vegetable oil, eggs, and vanilla extract. Mix until well combined."
            );

            Recipe strawberryCake = new Recipe(
                    "Strawberry Cheesecake",
                    "https://i.imgur.com/ftirewH.jpg",
                    Recipe.RecipeType.DESSERT,
                    "Enjoy the creamy goodness of cheesecake topped with fresh strawberries.",
                    240,
                    "1 ½ cups graham cracker crumbs, ¼ cup sugar, ⅓ cup melted butter, " +
                            "4 (8-ounce) packages cream cheese, 1 ¼ cups sugar, 2 tsp vanilla extract, " +
                            "4 eggs, ⅓ cup sour cream, ⅓ cup heavy cream, sliced strawberries",
                    "1. Preheat oven to 325°F (160°C). Grease a 9-inch springform pan.\n" +
                            "2. Mix graham cracker crumbs, sugar, and melted butter. Press onto the bottom of the prepared pan.\n" +
                            "3. In a large bowl, beat cream cheese, sugar, and vanilla extract until smooth."
            );

            Recipe applePie = new Recipe(
                    "Apple Pie",
                    "https://i.imgur.com/Q7RyUpV.jpg",
                    Recipe.RecipeType.DESSERT,
                    "Savor the classic taste of homemade apple pie with a buttery crust and cinnamon-spiced apples.",
                    90,
                    "For the crust: 2 ½ cups all-purpose flour, 1 cup unsalted butter (cold), " +
                            "1 tsp salt, 1 tsp sugar, 6-8 tbsp ice water. For the filling: 6 cups thinly sliced apples",
                    "1. Prepare the crust: In a food processor, pulse flour, salt, and sugar. Add cold butter and pulse " +
                            "until the mixture resembles coarse crumbs. Slowly add ice water and pulse until the dough comes together."
            );

            Recipe tiramisu = new Recipe(
                    "Tiramisu",
                    "https://i.imgur.com/fZDXLkw.jpg",
                    Recipe.RecipeType.DESSERT,
                    "Delight in this classic Italian dessert made with layers of coffee-soaked ladyfingers and mascarpone cream.",
                    45,
                    "6 egg yolks, ¾ cup granulated sugar, 1 cup mascarpone cheese, 1 ½ cups heavy cream, " +
                            "2 cups strong brewed coffee, 1 package ladyfinger cookies, cocoa powder for dusting",
                    "1. In a heatproof bowl, whisk egg yolks and sugar over a pot of simmering water until thickened.\n" +
                            "2. Remove from heat and whisk in mascarpone until smooth."
            );




            em.persist(ProteinOatmeal);
            em.persist(ProteinPizza);
            em.persist(VeggieStirFry);
            em.persist(FruitSalad);
            em.persist(ChickenQuinoaBowl);
            em.persist(AvocadoToast);
            em.persist(LentilSoup);
            em.persist(TofuScramble);
            em.persist(YogurtParfait);
            em.persist(TurkeyVeggieWrap);
            em.persist(SmoothieBowl);
            em.persist(ShrimpBroccoliStirFry);
            em.persist(QuinoaSalad);
            em.persist(BlueberryPancakes);
            em.persist(GrilledVeggieSandwich);
            em.persist(BakedSalmonRoastedVeggies);
            em.persist(BananaNutOvernightOats);
            em.persist(ChickpeaSalad);
            em.persist(EggplantParmesan);
            em.persist(GreenSmoothie);
            em.persist(TunaSaladWrap);
            em.persist(VeggieFrittata);
            em.persist(CaramelBliss);
            em.persist(coffeeMartini);
            em.persist(lemonDropFizz);
            em.persist(lycheeSparkler);
            em.persist(limeMargarita);
            em.persist(orangeDream);
            em.persist(passionfruitParadise);
            em.persist(pineapplePunch);
            em.persist(strawberryDaiquiri);
            em.persist(watermelonMintCooler);
            em.persist(chocolateCake);
            em.persist(strawberryCake);
            em.persist(applePie);
            em.persist(tiramisu);

            em.getTransaction().commit();
        }
    }
}
