package new8puzzle;


// ----------------------------------------------------------------

// Author: Siddharth Sutar
// Date: 16/09/2022
// Description: Implementation of 8 puzzle game using Java
// flaws: note that I have limited number of nodes to create this limits the program's ability to search or else my stack overflows 
// A * start and manHatthan algorithm are implemented

// ----------------------------------------------------------------

// Node class which acts like a tree structure
class Node{
    Node left = null;
    Node right = null;
    Node down = null;
    Node up = null;
    int[][] arr;
    Node(int array[][]) {
        arr = array;
    }

    //  we will be using this static method each time we wanna print a node 
    public static void printNode(Node node) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(node.arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// so we will be generating the tree and while generating the tree we will apply A * and Manhattan distance algorithm
class MyTree{
    int x,y,iterations = -1,previous;
    int midC = 0, mid = 0, corner = 0;
    char meth = 'm'; // change meth to m for manHatthan distance, a for A*star 
    Node newNode;

    Node makeMyTree(int[][] start,int[][] goal){
        iterations += 1;
        Node root = new Node(start);
        x = findPositionX(root);
        y = findPositionY(root);
        // note iterations can go upto 5000 nodes
        if(iterations == 50){
            return root;
        }
        // Security Check
        if(x==-1 && y==-1){
            System.out.println(-1);
            System.exit(-1);
        }
        // for middle element, then for the corner elements, then for mid corner element 
        // we will be using variables mid,corner and midC
        if(x==1 && y==1){
            if(mid==0){
                mid++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.left = new Node(moveLeft(root, x, y).arr);
                solution.searchForTheGoal(root.left, goal,meth, previous, iterations);
            }
            else if(mid==1){
                mid++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.right = new Node(moveRight(root, x, y).arr);
                solution.searchForTheGoal(root.right, goal, meth, previous, iterations);
            }
            else if(mid==2){
                mid++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.up = new Node(moveUp(root, x, y).arr);
                solution.searchForTheGoal(root.up, goal, meth, previous, iterations);
            }
            else{
                mid=0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.down = new Node(moveDown(root, x, y).arr);
                solution.searchForTheGoal(root.down, goal, meth, previous, iterations);
            }
        }
        else if(x==0 && y==0){
            if(corner==0){
                corner++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.down = new Node(moveDown(root, x, y).arr);
                solution.searchForTheGoal(root.down, goal, meth, previous, iterations);
            }
            else if(corner==1){
                corner = 0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.right = new Node(moveRight(root, x, y).arr);
                solution.searchForTheGoal(root.right, goal, meth, previous, iterations);
            }
        }
        else if(x == 0 && y == 2){
            if(corner==0){
                corner++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.left = new Node(moveLeft(root, x, y).arr);
                solution.searchForTheGoal(root.left, goal, meth, previous, iterations);
            }
            else if(corner==1){
                corner=0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.down = new Node(moveDown(root, x, y).arr);
                solution.searchForTheGoal(root.down, goal, meth, previous, iterations);
            }
        }
        else if (x == 2 && y == 0){
            if(corner==0){
                corner++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.up = new Node(moveUp(root, x, y).arr);
                solution.searchForTheGoal(root.up, goal, meth, previous, iterations);
            }
            else if(corner==1){
                corner=0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.right = new Node(moveRight(root, x, y).arr);
                solution.searchForTheGoal(root.right, goal, meth, previous, iterations);
            }
        }
        else if(x == 2 && y == 2){
            if(corner==0){
                corner++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.up = new Node(moveUp(root, x, y).arr);
                solution.searchForTheGoal(root.up, goal, meth, previous, iterations);
            }
            else if(corner==1){
                corner=0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.left = new Node(moveLeft(root, x, y).arr);
                solution.searchForTheGoal(root.left, goal, meth, previous, iterations);
            }
        }
        else if(x == 0 && y == 1){
            if(midC==0){
                midC++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.left = new Node(moveLeft(root, x, y).arr);
                solution.searchForTheGoal(root.left, goal, meth, previous, iterations);
            }
            else if(midC==1){
                midC++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.right = new Node(moveRight(root, x, y).arr);
                solution.searchForTheGoal(root.right, goal, meth, previous, iterations);
            }
            else if(midC==2){
                midC=0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.down = new Node(moveDown(root, x, y).arr);
                solution.searchForTheGoal(root.down, goal, meth, previous, iterations);
            }
        }
        else if(x == 1 && y == 0){
            if(midC==0){
                midC++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.up = new Node(moveUp(root, x, y).arr);
                solution.searchForTheGoal(root.up, goal, meth, previous, iterations);
            }
            else if(midC==1){
                midC++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.down = new Node(moveDown(root, x, y).arr);
                solution.searchForTheGoal(root.down, goal, meth, previous, iterations);
            }
            else if(midC==2){
                midC=0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.right = new Node(moveRight(root, x, y).arr);
                solution.searchForTheGoal(root.right, goal, meth, previous, iterations);
            }
        }
        else if (x == 1 && y == 2){
            if(midC==0){
                midC++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.up = new Node(moveUp(root, x, y).arr);
                solution.searchForTheGoal(root.up, goal, meth, previous, iterations);
            }
            else if(midC==1){
                midC++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.down = new Node(moveDown(root, x, y).arr);
                solution.searchForTheGoal(root.down, goal, meth, previous, iterations);
            }
            else if(midC==2){
                midC=0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.left = new Node(moveLeft(root, x, y).arr);
                solution.searchForTheGoal(root.left, goal, meth, previous, iterations);
            }
        }
        else if(x == 2 && y == 1){
            if(midC==0){
                midC++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.left = new Node(moveLeft(root, x, y).arr);
                solution.searchForTheGoal(root.left, goal, meth, previous, iterations);
            }
            else if(midC==1){
                midC++;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.right = new Node(moveRight(root, x, y).arr);
                solution.searchForTheGoal(root.right, goal, meth, previous, iterations);
            }
            else if(midC==2){
                midC=0;
                previous = solution.calculateFnValue(root, goal,iterations);
                root.up = new Node(moveUp(root, x, y).arr);
                solution.searchForTheGoal(root.up, goal, meth, previous, iterations);
            }
        }
        return makeMyTree(root.arr,goal);
    }

    static int findPositionX(Node node) {
        if(node == null) {
            return -1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (node.arr[i][j] == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int findPositionY(Node node) {
        if (node == null) {
            return -1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (node.arr[i][j] == 0) {
                    return j;
                }
            }
        }
        return -1;
    }

    // move left
    Node moveLeft(Node node, int x, int y) {
        int temp;
        Node.printNode(node);
        System.out.println("Move Left");
        if (x == 1 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][0];
            node.arr[1][0] = temp;
            return node;
        } else if (x == 0 && y == 2) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[0][1];
            node.arr[0][1] = temp;
            return node;
        } else if (x == 0 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[0][0];
            node.arr[0][0] = temp;
            return node;
        } else if (x == 1 && y == 2) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][1];
            node.arr[1][1] = temp;
            return node;
        } else if (x == 2 && y == 2) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[2][1];
            node.arr[2][1] = temp;
            return node;
        } else if (x == 2 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[2][0];
            node.arr[2][0] = temp;
            return node;
        } else {
            System.out.println("Something is wrong");
            System.exit(-1);
        }
        return node;
    }

    // moving right in column 0 and 1
    Node moveRight(Node node, int x, int y) {
        int temp;
        Node.printNode(node);
        System.out.println("Move Right");
        if (x == 0 && y == 0) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[0][1];
            node.arr[0][1] = temp;
            return node;
        } else if (x == 0 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[0][2];
            node.arr[0][2] = temp;
            return node;
        } else if (x == 1 && y == 0) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][1];
            node.arr[1][1] = temp;
            return node;
        } else if (x == 1 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][2];
            node.arr[1][2] = temp;
            return node;
        } else if (x == 2 && y == 0) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[2][1];
            node.arr[2][1] = temp;
            return node;
        } else if (x == 2 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[2][2];
            node.arr[2][2] = temp;
            return node;
        } else {
            System.out.println("Something is wrong");
            System.exit(-1);
        }
        return node;
    }

    // moving up row 1 and 2
    Node moveUp(Node node, int x, int y) {
        int temp;
        Node.printNode(node);
        System.out.println("Move Up");
        if (x == 1 && y == 0) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[0][0];
            node.arr[0][0] = temp;
            return node;
        } else if (x == 1 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[0][1];
            node.arr[0][1] = temp;
            return node;
        } else if (x == 1 && y == 2) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[0][2];
            node.arr[0][2] = temp;
            return node;
        } else if (x == 2 && y == 0) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][0];
            node.arr[1][0] = temp;
            return node;
        } else if (x == 2 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][1];
            node.arr[1][1] = temp;
            return node;
        } else if (x == 2 && y == 2) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][2];
            node.arr[1][2] = temp;
            return node;
        } else {
            System.out.println("Something is wrong");
            System.exit(-1);
        }
        return node;
    }

    // moving down row 0 and 1
    Node moveDown(Node node, int x, int y) {
        int temp;
        Node.printNode(node);
        System.out.println("Move Down");
        if (x == 0 && y == 0) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][0];
            node.arr[1][0] = temp;
            return node;
        } else if (x == 0 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][1];
            node.arr[1][1] = temp;
            return node;
        } else if (x == 0 && y == 2) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[1][2];
            node.arr[1][2] = temp;
            return node;
        } else if (x == 1 && y == 0) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[2][0];
            node.arr[2][0] = temp;
            return node;
        } else if (x == 1 && y == 1) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[2][1];
            node.arr[2][1] = temp;
            return node;
        } else if (x == 1 && y == 2) {
            temp = node.arr[x][y];
            node.arr[x][y] = node.arr[2][2];
            node.arr[2][2] = temp;
            return node;
        } else {
            System.out.println("Something is wrong");
            System.exit(-1);
        }
        return node;
    }
}

class solution{
    public static void searchForTheGoal(Node node, int[][] goal,char method,int prev,int depth){
        int fn = 0, manHattanDistance = 0;
        if(method == 'a'){
            fn = calculateFnValue(node, goal, depth);
            int g = fn - depth;
            System.out.println("for the below node f(n): " + fn+",g(n): "+ g);
            if(fn < prev){
                if(g == 0){
                    System.out.println("Goal reached!");
                    Node.printNode(node); 
                    System.exit(0);
                }
            }
            else{
                node = null;
                System.gc();
            }
        }
        else if(method == 'm'){
            manHattanDistance = calculateManhattanValue(node, goal);
            System.out.println("Manhattan distance: " + manHattanDistance);
            if(manHattanDistance == 0){
                System.out.println("Goal Reached!");
                Node.printNode(node);
                System.exit(0);
            }
        }
        else{
            System.out.println("Wrong method");
            System.exit(-1);
        }
    }

    // This will be used when searching for the goal using A * Algorithm
    static int calculateFnValue(Node node,int[][] goal,int depth){
        // g = depth of tree
        // h = no of misplaced tiles
        int f = 0,g=0,h=0;  
        g = depth;
        h = misplacedTiles(node, goal);
        f = g + h;
        return f;
    }

    static int misplacedTiles(Node node,int[][] goal){  
        int mis = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){  
                if(node.arr[i][j] != goal[i][j]){
                    mis++;
                }
            }
        }
        return mis;
    }

    // by using manHatthan values
    static int calculateManhattanValue(Node node,int[][] goal){
        int manHatthan = 0,counter = 0,xgoal = 0,ygoal = 0;
        int[] elements = new int[9];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(node.arr[i][j] == goal[i][j]){
                    elements[counter] = 0;
                    manHatthan+=elements[counter];
                }
                else if(node.arr[i][j] != goal[i][j]){
                    xgoal = xcalculator(goal,node.arr[i][j]);
                    ygoal = ycalculator(goal,node.arr[i][j]);
                    elements[counter] = manHatthanValue(i,j,xgoal,ygoal);
                    manHatthan+=elements[counter];
                }
                counter++;
            }
        }
        for(int i=0;i<9;i++){
            elements[i] = 0;
        }
        return manHatthan;
    }

    // provides us the manHatthanValue
    static int manHatthanValue(int xstart,int ystart,int xgoal, int ygoal) {
        int value = 0,xdiff,ydiff;
        xdiff = Math.abs(xstart - xgoal);
        ydiff = Math.abs(ystart - ygoal);
        value = xdiff + ydiff;
        return value;
    } 

    // provide us x for certain values in array
    static int xcalculator(int[][] arr,int value){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == value){
                    return i;
                }
            }
        }
        return -1;
    } 

    // provide us y for certain values in array
    static int ycalculator(int[][] arr, int value){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == value){
                    return j;
                }
            }
        }
        return - 1;
    }
}

public class puzzle8New {
    public static void main(String[] args) {
        final int[][] start = { { 3, 1, 2 }, { 4, 6, 5 }, { 7, 0, 8 } };
        int[][] goal  = { { 7, 3, 2 }, { 4, 5, 0 }, { 1, 6, 8 } };
        MyTree mytree = new MyTree();
        Node root = mytree.makeMyTree(start,goal);
        Node.printNode(root);
        root = null;
        System.gc(); // to clean up the memory allocated
        System.out.println("Goal was not found!");
        System.exit(0);
    }
}
