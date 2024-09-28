% we need to check is the position is in our boundry limits (we have a 5*5 grid)
is_position_valid((Row, Column)) :- Row >= 1, Row =< 5, Column >= 1, Column =< 5.

% we need to check if a position has an obstacle
is_position_obstacle((Row, Column), Obstacles_list) :- member((Row, Column), Obstacles_list).

% we need to define movement types, the rules' names are same for us to design the program easier, 
% prolog will try every movement to find a path
% first move is to right
% second move is to down
% third move is to left
% fourth move is to up
move((Row, Column), (Row, New_column)) :- New_column is Column + 1, is_position_valid((Row, New_column)).
move((Row, Column), (New_row, Column)) :- New_row is Row + 1, is_position_valid((New_row, Column)).
move((Row, Column), (Row, New_column)) :- New_column is Column - 1, is_position_valid((Row, New_column)).
move((Row, Column), (New_row, Column)) :- New_row is Row - 1, is_position_valid((New_row, Column)).

% this function is finding the reversed path
reversed_path(Exit, Exit, _Obstacles_list, Reversed_path, Reversed_path).
reversed_path(Current_position, Exit, Obstacles_list, Visited_positions, Reversed_path) :-
    move(Current_position, Next_position),
    is_position_valid(Next_position),
    \+ is_position_obstacle(Next_position, Obstacles_list), % we are checking if the new position has an obstacle
    \+ member(Next_position, Visited_positions),  % we are checking if the position is already visited
    reversed_path(Next_position, Exit, Obstacles_list, [Next_position|Visited_positions], Reversed_path). % calling the functor again with an updated visited positions list

% we now can find our path
path(Start, Exit, Obstacles_list, Path) :-
    reversed_path(Start, Exit, Obstacles_list, [Start], Reversed_path),
    reverse(Reversed_path, Path).