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
            Recipe ProteinOatmeal = new Recipe("Protein Oatmeal", "https://i.imgur.com/5Z9X9ZM.jpg", Recipe.RecipeType.BREAKFAST, "A delicious and healthy breakfast", 10, "1/2 cup oats, 1 cup milk, 1 scoop protein powder, 1/2 cup berries", "1. Mix oats and milk in a bowl\n2. Microwave for 2 minutes\n3. Add protein powder and berries");
            Recipe ProteinPizza = new Recipe("Protein Pizza", "https://i.imgur.com/5Z9X9ZM.jpg", Recipe.RecipeType.DINNER, "A delicious and healthy dinner", 30, "1/2 cup oats, 1 cup milk, 1 scoop protein powder, 1/2 cup berries", "1. Mix oats and milk in a bowl\n2. Microwave for 2 minutes\n3. Add protein powder and berries");
            em.persist(ProteinOatmeal);
            em.persist(ProteinPizza);
            em.getTransaction().commit();
        }
    }
}
