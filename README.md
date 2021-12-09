# CHEF
This is the CHEF-Application, which helps indecicisve people to choose a meal.

Link to this Repo: [CHEF](https://github.com/StrykerDelkar/chef)

## Generate Meals
Generate a new Meal containing a main dish as well as a dessert by clicking on the "Generate Delicious Meal" Button

### Dessert Type
You can choose wich type of dessert you would like to consume with your main dish, like cake or ice cream.

### Desired Ingredient

Just enter an Ingredient and submit it, and the algorithm will only provide main dishes containing this specific ingredient

## Combine Ingredients

### Ingredient Count

Just choose a number of ingredients you'd like to use
 
### Desired Ingredient

Just enter an Ingredient and submit it, and the algorithm will only provide combinations containing this specific ingredient

### Blacklisting

By clicking on "Add to Blacklist", the last combination will added to the app's blacklist, so you won't get this combination again
If you want to, you can also clear the blacklist by clicking on the appropriate button.

## Intolerances
Both key features include food intolerance handling.
Just switch on the sliders for any intolerance you have.

Note: This feature isn't fully implemented yet and will be completed in future releases

## Known Issues

### Ingredient Filtering

## The ingredient Filtering seems not to work properly yet.
For some reason the check, wether an ingredient-String is contained in an ArrayList of Strings will allways return false.
I have not come up with a solution yet, but I'll keep working on it.
