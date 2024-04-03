Created by Bryan Chiam (chibj006)

Task 4: Custom Functionality
I created a Chomper class (plant) and a BirdTargetedArea class.

The added functionality is that during every tick, there is a chance that your produce will be attacked by a bird, 
when it is targeted by a bird, you will be able to see it as your produce would be replace with "!".
you as the user will have a choice to either chase the bird away, or leave it to be stolen by the birds. If
you chase the bird away, the original plant will be returned, if it is stolen, only soil is left.

The Chomper plant however, can be targeted by the birds as well, but instead of the birds stealing the plant, 
the chomper will actually consume the bird, for each bird that the chomper eats, it will gain $1 in value, 
which will be obtained when you sell the Chomper. It's symbol will return back to its original as well after 
being targeted by the bird. Every time the chomper eats more than 3 birds, it will age by 1, and then it has
to eat 3 more birds again.
