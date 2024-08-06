package codefile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2115 {
	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] suppliesArray) {
        Set<String> supplies = new HashSet<>();
        for(String supply : suppliesArray) {
            supplies.add(supply);
        }
        Map<String, List<String>> recipiesAndIngredients = new HashMap<>();
        for(int i = 0; i < recipes.length; i++) {
            recipiesAndIngredients.put(recipes[i], ingredients.get(i));
        }
        Set<String> visited = new HashSet<>();
        Set<String> currentPath = new HashSet<>();
        
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < recipes.length; i++) {
            if(dfs(recipiesAndIngredients, supplies, visited, currentPath, recipes[i])) {
                result.add(recipes[i]);
            }
        }
        
        return result;
    }
   
    boolean dfs(Map<String, List<String>> recipiesAndIngredients, Set<String> supplies, Set<String> visited, Set<String> currentPath, String recipe) {
        if(currentPath.contains(recipe)) {
            return false;
        }
        if(visited.contains(recipe)) {
            return true;
        }
        currentPath.add(recipe);
        visited.add(recipe);
        List<String> ingredients = recipiesAndIngredients.get(recipe);
        
        if(ingredients == null) {
            return false;
        }
        
        for(String ingredient : ingredients) {
            if(!supplies.contains(ingredient) && !dfs(recipiesAndIngredients, supplies, visited, currentPath, ingredient)) {
                return false;
            }
        }
        
        currentPath.remove(recipe);
        return true;
    }
}
