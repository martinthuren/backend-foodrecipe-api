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
            Recipe ProteinOatmeal = new Recipe("Protein Oatmeal", "https://i.imgur.com/VJFSqB7.jpeg", Recipe.RecipeType.BREAKFAST, "A delicious and healthy breakfast", 10, "1/2 cup oats, 1 cup milk, 1 scoop protein powder, 1/2 cup berries", "1. Mix oats and milk in a bowl\n2. Microwave for 2 minutes\n3. Add protein powder and berries");

            Recipe ProteinPizza = new Recipe("Protein Pizza", "https://i.imgur.com/5Z9X9ZM.jpg", Recipe.RecipeType.DINNER, "A delicious and healthy dinner", 30, "1/2 cup oats, 1 cup milk, 1 scoop protein powder, 1/2 cup berries", "1. Mix oats and milk in a bowl\n2. Microwave for 2 minutes\n3. Add protein powder and berries");

            Recipe VeggieStirFry = new Recipe("Veggie Stir-Fry", "https://i.imgur.com/abc123.jpg", Recipe.RecipeType.DINNER, "A flavorful vegetarian dinner", 25, "2 cups mixed vegetables, 1 cup tofu, 2 tbsp soy sauce, 1 tbsp oil", "1. Heat oil in a pan\n2. Add vegetables and tofu, stir-fry for 10 minutes\n3. Add soy sauce and cook for another 5 minutes");

            Recipe FruitSalad = new Recipe("Fruit Salad", "https://i.imgur.com/def456.jpg", Recipe.RecipeType.SNACK, "A refreshing and healthy snack", 15, "2 apples, 2 bananas, 1 cup grapes, 1/2 cup nuts, honey (optional)", "1. Chop fruits and mix in a bowl\n2. Add nuts and drizzle honey if desired");

            Recipe ChickenQuinoaBowl = new Recipe("Chicken Quinoa Bowl", "https://i.imgur.com/ghi789.jpg", Recipe.RecipeType.LUNCH, "A protein-packed lunch option", 35, "1 cup quinoa, 1 chicken breast, 1 cup broccoli, 1 tbsp olive oil, spices", "1. Cook quinoa as per instructions\n2. Grill chicken and chop into pieces\n3. Steam broccoli\n4. Mix all ingredients and add spices");

            Recipe AvocadoToast = new Recipe("Avocado Toast", "https://i.imgur.com/jkl012.jpg", Recipe.RecipeType.BREAKFAST, "A trendy and nutritious breakfast", 15, "2 slices whole grain bread, 1 ripe avocado, salt, pepper, red pepper flakes (optional)", "1. Toast bread slices\n2. Mash avocado and spread on toast\n3. Sprinkle salt, pepper, and red pepper flakes");

            Recipe LentilSoup = new Recipe("Lentil Soup", "https://i.imgur.com/mno345.jpg", Recipe.RecipeType.DINNER, "A hearty and comforting soup", 40, "1 cup lentils, 2 carrots, 2 celery stalks, 1 onion, 4 cups vegetable broth, spices", "1. Chop vegetables\n2. Sauté veggies in a pot\n3. Add lentils, broth, and spices\n4. Simmer for 30 minutes");

            Recipe TofuScramble = new Recipe("Tofu Scramble", "https://i.imgur.com/pqr678.jpg", Recipe.RecipeType.BREAKFAST, "A vegan alternative to scrambled eggs", 20, "1 block tofu, 1 bell pepper, 1 onion, 2 tbsp nutritional yeast, spices", "1. Crumble tofu in a pan\n2. Sauté chopped pepper and onion\n3. Add tofu, nutritional yeast, and spices");

            Recipe YogurtParfait = new Recipe("Greek Yogurt Parfait", "https://i.imgur.com/stu901.jpg", Recipe.RecipeType.SNACK, "A healthy and customizable snack", 10, "1 cup Greek yogurt, 1/2 cup granola, 1/2 cup mixed berries, honey (optional)", "1. Layer yogurt, granola, and berries in a glass\n2. Drizzle honey if desired");

            Recipe TurkeyVeggieWrap = new Recipe("Turkey Veggie Wrap", "https://i.imgur.com/vwx234.jpg", Recipe.RecipeType.LUNCH, "A quick and nutritious lunch option", 15, "4 slices turkey, 1 whole grain wrap, lettuce, tomato, cucumber, hummus", "1. Spread hummus on wrap\n2. Layer turkey slices and veggies\n3. Roll up the wrap");

            Recipe SmoothieBowl = new Recipe("Smoothie Bowl", "https://i.imgur.com/yzabc5.jpg", Recipe.RecipeType.BREAKFAST, "A vibrant and energizing breakfast", 10, "1 frozen banana, 1/2 cup mixed berries, 1/2 cup spinach, 1/2 cup almond milk, toppings (granola, sliced fruits, seeds)", "1. Blend banana, berries, spinach, and almond milk\n2. Pour into a bowl and add toppings");

            Recipe ShrimpBroccoliStirFry = new Recipe("Shrimp Broccoli Stir-Fry", "https://i.imgur.com/678def.jpg", Recipe.RecipeType.DINNER, "A flavorful seafood dinner", 20, "1 lb shrimp, 2 cups broccoli florets, 2 garlic cloves, 2 tbsp soy sauce, 1 tbsp sesame oil", "1. Sauté minced garlic in oil\n2. Add shrimp and cook\n3. Add broccoli and soy sauce, stir-fry until tender");

            Recipe QuinoaSalad = new Recipe("Quinoa Salad", "https://i.imgur.com/901ghi.jpg", Recipe.RecipeType.LUNCH, "A refreshing and protein-rich salad", 25, "1 cup quinoa, 1 cucumber, 1 bell pepper, cherry tomatoes, feta cheese, dressing", "1. Cook quinoa as per instructions\n2. Chop veggies and mix with quinoa\n3. Add feta cheese and dressing");

            Recipe BlueberryPancakes = new Recipe("Blueberry Pancakes", "https://i.imgur.com/234jkl.jpg", Recipe.RecipeType.BREAKFAST, "Delicious fluffy pancakes with a burst of blueberries", 20, "1 cup flour, 1 tbsp sugar, 1 tsp baking powder, 1 egg, 1 cup milk, 1/2 cup blueberries", "1. Mix dry ingredients in a bowl\n2. In another bowl, whisk egg and milk\n3. Combine wet and dry ingredients\n4. Fold in blueberries\n5. Cook pancakes on a griddle");

            Recipe GrilledVeggieSandwich = new Recipe("Grilled Vegetable Sandwich", "https://i.imgur.com/567mno.jpg", Recipe.RecipeType.LUNCH, "A hearty sandwich filled with grilled veggies", 25, "Assorted vegetables (zucchini, bell peppers, eggplant), 4 slices whole grain bread, cheese, pesto (optional)", "1. Slice vegetables and grill them\n2. Toast bread slices\n3. Layer vegetables and cheese between bread\n4. Spread pesto if desired");

            Recipe BakedSalmonRoastedVeggies = new Recipe("Baked Salmon with Roasted Vegetables", "https://i.imgur.com/opq789.jpg", Recipe.RecipeType.DINNER, "A nutritious and flavorful dinner option", 35, "4 salmon fillets, assorted vegetables (carrots, potatoes, broccoli), olive oil, herbs", "1. Preheat oven\n2. Season salmon with herbs\n3. Chop veggies and toss with oil\n4. Bake salmon and veggies in the oven");

            Recipe BananaNutOvernightOats = new Recipe("Banana Nut Overnight Oats", "https://i.imgur.com/rst012.jpg", Recipe.RecipeType.BREAKFAST, "Prepare ahead for a quick morning meal", 5, "1/2 cup rolled oats, 1/2 cup almond milk, 1 ripe banana, chopped nuts, honey (optional)", "1. Mix oats and almond milk in a jar\n2. Add mashed banana and nuts\n3. Refrigerate overnight");

            Recipe ChickpeaSalad = new Recipe("Chickpea Salad", "https://i.imgur.com/uvw345.jpg", Recipe.RecipeType.LUNCH, "A protein-packed and refreshing salad", 20, "1 can chickpeas, cucumber, cherry tomatoes, red onion, feta cheese, lemon vinaigrette", "1. Rinse and drain chickpeas\n2. Chop veggies and mix with chickpeas\n3. Add feta cheese and dress with lemon vinaigrette");

            Recipe EggplantParmesan = new Recipe("Eggplant Parmesan", "https://i.imgur.com/xyz678.jpg", Recipe.RecipeType.DINNER, "A satisfying vegetarian Italian dish", 50, "2 eggplants, breadcrumbs, marinara sauce, mozzarella cheese, parmesan cheese, herbs", "1. Slice eggplants and coat with breadcrumbs\n2. Bake until golden\n3. Layer with marinara and cheeses\n4. Bake until cheese melts");

            Recipe GreenSmoothie = new Recipe("Green Smoothie", "https://i.imgur.com/123abc.jpg", Recipe.RecipeType.SNACK, "A nutritious and refreshing drink", 10, "2 cups spinach, 1 banana, 1/2 avocado, 1 cup almond milk, honey (optional)", "1. Blend spinach, banana, avocado, and almond milk\n2. Sweeten with honey if desired");

            Recipe TunaSaladWrap = new Recipe("Tuna Salad Wrap", "https://i.imgur.com/456def.jpg", Recipe.RecipeType.LUNCH, "A simple and protein-rich lunch option", 15, "1 can tuna, lettuce, tomato, onion, whole grain wrap, Greek yogurt (or mayo)", "1. Mix tuna with Greek yogurt (or mayo)\n2. Spread on wrap and add veggies\n3. Roll up the wrap");

            Recipe VeggieFrittata = new Recipe("Veggie Frittata", "https://i.imgur.com/789ghi.jpg", Recipe.RecipeType.BREAKFAST, "A versatile and satisfying breakfast dish", 30, "6 eggs, assorted vegetables (bell peppers, spinach, onions), cheese, herbs", "1. Whisk eggs in a bowl\n2. Sauté veggies in a pan\n3. Pour eggs over veggies, sprinkle cheese and herbs\n4. Bake until set");

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

            em.getTransaction().commit();
        }
    }
}
