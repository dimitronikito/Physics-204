#Nikitopoulos_Dimitrios_Project ::: Sierpinski Triangle

import turtle                               #imports turtle graphics in order to draw
t = turtle.Turtle()
t.penup()                   
t.goto(-300, -300)                          #moves turtle to this position on screen
t.pendown()                                 #puts pen down to start drawing

def sierpinski(length, level):              #sierpinski draw function

    if level == 0:                          #if level of recursion is 0 (BASE CASE)
        for i in range(0, 3):               #this process will iterate 3 times
            t.forward(length)               #turtle goes forward and draws desired length
            t.left(120)                     #turtle turns 120 degrees

    else:                                   #if not zero continue
        sierpinski(length/2, level-1)       #recursive call: in order to reach base case, triangle 
        t.forward(length/2)                 #needs to get smaller (length/2) and current level is 
                                            #subtracted by 1 to get to next level

        sierpinski(length/2, level-1)       #2nd iteration  
        t.backward(length/2)
        t.left(60)
        t.forward(length/2)
        t.right(60)

        sierpinski(length/2, level-1)       #3rd iteration (every level draws 3 triangle)
        t.left(60)
        t.backward(length/2)
        t.right(60)
                     
t.speed(50)                                 
sierpinski(512, 6)                          #draw with an order of n 
turtle.Screen().exitonclick()                
