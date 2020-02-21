///**
// * Created by ziad on 11/26/19.
// */
// import java.awt.Point;
// import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//import java.util.Stack;
//import java.lang.Math;
//public class AStar8 {
//        private static HashMap<Integer, Point> targets = new HashMap<Integer, Point>();
//        public static Stack<State> search(State start)
//        {
//            int index;
//            //Initialize Targets
//            int i=0,j=0,key=0;
//            for(i=0;i<3;i++)
//                for(j=0;j<3;j++)
//                {
//                    targets.put(key, new Point(j,i));
//                    key++;
//                }
//            HashMap<String, Integer> explored = new HashMap<String, Integer>();
//            ArrayList<State> frontier = new ArrayList<State>();
//            ArrayList<State> array = new ArrayList<State>();
//            Stack<State> stack = new Stack<State>();
//
//            frontier.add(start);										//add start state to the frontier
//            explored.put(State.convertMatrixToKey(start), 0);
//            State currentState=new State();
//
//
//            while(frontier.size()>0)
//            {
//
//                currentState=frontier.get(0);						//get state S with minimum f(n)
//                frontier.remove(0);
//                // dequeue state S
//                // add current state to an arraylist(States) so back tracking could be possible;
//                currentState.setCurrentIndex(array.size());
//                array.add(currentState);
//
//                if(!State.compare(currentState))
//                {
//                    //search for 0 tile;
//                    Point tile=tileIndex(currentState);
//                    if(tile.x>0)				//move left
//                    {
//
//                        State s1=new State();
//                        cloneMatrix(s1, currentState);
//                        s1.matrix[tile.y][tile.x]=s1.matrix[tile.y][tile.x-1];
//                        s1.matrix[tile.y][tile.x-1]=0;
//                        s1.setG(currentState.getG()+1);
//                        s1.setH(euclideanDistanceHeuristics(s1));
//                        s1.setF(s1.getG()+s1.getH());
//                        if(!explored.containsKey(State.convertMatrixToKey(s1)))
//                        {
//
//
//                            index=getIndex(frontier,s1);
//                            frontier.add(index, s1);
//                            explored.put(State.convertMatrixToKey(s1), 0);
//
//                        }else {
//                            int indx=comparefrontiers(frontier, s1);
//
//                            if(indx!= -1 && s1.getF()<frontier.get(indx).getF())
//                            {
//                                frontier.get(indx).setG(s1.getG());
//                                frontier.get(indx).setH(s1.getH());
//                                frontier.get(indx).setF(s1.getF());
//                                frontier.get(indx).setParentIndex(s1.getParentIndex());
//
//                            }
//
//
//                        }
//
//                    }
//                    if(tile.y>0)	//Move Up
//                    {
//                        State s3=new State();
//                        cloneMatrix(s3, currentState);
//                        s3.matrix[tile.y][tile.x]=s3.matrix[tile.y-1][tile.x];
//                        s3.matrix[tile.y-1][tile.x]=0;
//                        s3.setG(currentState.getG()+1);
//                        s3.setH(euclideanDistanceHeuristics(s3));
//                        s3.setF(s3.getG()+s3.getH());
//                        if(!explored.containsKey(State.convertMatrixToKey(s3)))
//                        {
//
//                            index=getIndex(frontier,s3);
//
//                            frontier.add(index, s3);
//                            explored.put(State.convertMatrixToKey(s3), 0);
//
//                        }else {
//                            int indx=comparefrontiers(frontier, s3);
//
//                            if(indx!= -1 && s3.getF()<frontier.get(indx).getF())
//                            {
//                                frontier.get(indx).setG(s3.getG());
//                                frontier.get(indx).setH(s3.getH());
//                                frontier.get(indx).setF(s3.getF());
//                                frontier.get(indx).setParentIndex(s3.getParentIndex());
//
//                            }
//
//
//                        }
//                    }
//
//                    if(tile.x<2)	//Move Right
//                    {
//                        State s2=new State();
//                        cloneMatrix(s2, currentState);
//                        s2.matrix[tile.y][tile.x]=s2.matrix[tile.y][tile.x+1];
//                        s2.matrix[tile.y][tile.x+1]=0;
//                        s2.setG(currentState.getG()+1);
//                        s2.setH(euclideanDistanceHeuristics(s2));
//                        s2.setF(s2.getG()+s2.getH());
//                        if(!explored.containsKey(State.convertMatrixToKey(s2)))
//                        {
//
//                            index=getIndex(frontier,s2);
//
//                            frontier.add(index, s2);
//                            explored.put(State.convertMatrixToKey(s2), 0);
//
//                        }else {
//                            int indx=comparefrontiers(frontier, s2);
//
//                            if(indx!= -1 && s2.getF()<frontier.get(indx).getF())
//                            {
//                                frontier.get(indx).setG(s2.getG());
//                                frontier.get(indx).setH(s2.getH());
//                                frontier.get(indx).setF(s2.getF());
//                                frontier.get(indx).setParentIndex(s2.getParentIndex());
//
//                            }
//
//
//                        }
//                    }
//                    if(tile.y<2)	//Move down
//                    {
//                        State s4=new State();
//                        cloneMatrix(s4, currentState);
//                        s4.matrix[tile.y][tile.x]=s4.matrix[tile.y+1][tile.x];
//                        s4.matrix[tile.y+1][tile.x]=0;
//                        s4.setG(currentState.getG()+1);
//                        s4.setH(euclideanDistanceHeuristics(s4));
//                        s4.setF(s4.getG()+s4.getH());
//                        if(!explored.containsKey(State.convertMatrixToKey(s4)))
//                        {
//
//                            index=getIndex(frontier,s4);
//                            frontier.add(index, s4);
//                            explored.put(State.convertMatrixToKey(s4), 0);
//                        }else {
//                            int indx=comparefrontiers(frontier, s4);
//
//                            if(indx!= -1 && s4.getF()<frontier.get(indx).getF())
//                            {
//                                frontier.get(indx).setG(s4.getG());
//                                frontier.get(indx).setH(s4.getH());
//                                frontier.get(indx).setF(s4.getF());
//                                frontier.get(indx).setParentIndex(s4.getParentIndex());
//
//                            }
//                        }
//                    }
//                }
//                else {
//                    break;
//                }
//            }
//
//
//
//            stack.push(array.get(array.size()-1));
//            while(stack.peek().getParentIndex()!= -1)
//            {
//                stack.push(array.get(stack.peek().getParentIndex()));
//
//            }
////            System.out.println(array.size() + "     hashMap:"+explored    );
//            return stack;}
//    public static double euclideanDistanceHeuristics(State currentState)
//        {
//            double sum=0;
//            Point point;
//            int j,i;
//            for( i = 0;i<3;i++)
//                for(j=0;j<3;j++)
//                {
//                    point=targets.get(currentState.matrix[j][i]);
//                    sum+=Math.sqrt(Math.pow(point.getX()-i, 2)+Math.pow(point.getY()-j, 2));
//
//                }
//            return sum;
//
//        }
//
//        public static int getIndex(ArrayList<State> frontier,State s)
//        {	int index=0;
//            for(index=0;index<frontier.size();index++)
//            {
//                if(frontier.get(index).getF()>s.getF())
//                    return index;
//            }
//            return index;
//        }
//        public static Point tileIndex(State currentState) {
//            int i=0,j=0;
//            Point point = new Point();
//            for(i=0;i<3;i++)
//                for(j=0;j<3;j++)
//                {
//                    if(currentState.matrix[j][i] == 0)
//                    {
//                        point.x = i;
//                        point.y=j;
//                        break;
//                    }
//                }
//            return point;
//
//        }
//        public static void cloneMatrix(State newState,State currentState)
//        {
//            newState.setParentIndex(currentState.getCurrentIndex());
//            int i,j;
//            for(i=0;i<3;i++)
//                for(j=0;j<3;j++)
//                    newState.matrix[i][j]=currentState.matrix[i][j];
//        }
//        public static int comparefrontiers(ArrayList<State> frontier,State s)
//        {
//            int index=0;
//            for(index=0;index<frontier.size();index++)
//                if(compareStates(frontier.get(index),s))
//                    return index;
//            return -1;
//        }
//        public static boolean compareStates(State x,State s)
//        {	int i,j;
//            String keyX="",keyS="";
//            for(i=0;i<3;i++)
//                for(j=0;j<3;j++)
//                {
//                    keyS+=s.matrix[i][j];
//                    keyX+=x.matrix[i][j];
//                }
//            if(keyX==keyS)
//                return true;
//            return false;
//        }
//}
//
