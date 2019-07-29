package data_structure.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String [] args){
        System.out.println("Double linked list test");
        HeroNode2 hero1 = new HeroNode2(1,"songjiang","jishiyu");
        HeroNode2 hero2 = new HeroNode2(2,"lujunyi","yuqilin");
        HeroNode2 hero3 = new HeroNode2(3,"wuyong","zhiduoxing");
        HeroNode2 hero4 = new HeroNode2(4,"linchong","baozitou");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //modify
        HeroNode2 newHeroNode = new HeroNode2(4,"gonsunsheng","ruyunling");
        doubleLinkedList.update(newHeroNode);

        doubleLinkedList.list();

        //delete
        doubleLinkedList.del(3);
        System.out.println("After deleting: ");
        doubleLinkedList.list();
    }


}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    //show the whole linked list
    public void list(){
        if(head.next == null) {
            System.out.println("the linked list is empty");
            return;
        }
        HeroNode2 temp = head.next;
        while(true){
            //print out the node value
            System.out.println(temp);
            //check if it is the end of the linkedlist
            if(temp.next == null){
                break;
            }
            //move backward temp.next
            temp = temp.next;
        }
    }

    //add node
    //thoughts: when not considering the sequence
    //1. find the last node
    //2. link that node's next to the new node
    public void add(HeroNode2 heroNode){
        //as head node cannot move, we need a assistance node
        HeroNode2 temp = head;
        //loop through the linked list
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;

        }
        //when the while loop ends, temp is pointing to the last node
        //heroNode.pre pointing to the temp
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //modify, similar to single linked list
    public void update(HeroNode2 newHeroNode){
        //based on newHeroNode to update
        if(head.next == null) {
            System.out.println("the linked list is empty");
            return;
        }

        //based on need, find the node to modify
        //define a temp node
        HeroNode2 temp = head.next;
        boolean flag = false; // check if found
        while (true){
            if (temp == null){
                break; //reaching the end of the list
            }
            if(temp.no == newHeroNode.no){
                //it is the node
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //based on flag to check if found
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else{
            //not found
            System.out.printf("Haven't found the no. %d, cannot modify\n", newHeroNode.no);
        }
    }

    //delete a node
    //1. to a double linked list, we can find the node to be deleted.
    //2. then delete it directly
    public void del(int no){
        if(head.next == null){
            System.out.println("Empty linked list, cannot delete");
        }

        HeroNode2 temp = head.next;
        boolean flag = false; //mark if we find the node
        while (true){
            if(temp == null){
                //end of the linked list
                break;
            }
            if(temp.no == no){
                //found
                flag = true;
                break;
            }
            temp = temp.next; //move backward
        }
        if(flag){
            //found
            //temp.next = temp.next.next;
            temp.pre.next = temp.next;
            //condition is used to check if it is the last node
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else{
            System.out.println("The node to be deleted hasn't been found.");
        }
    }


}

//define the HeroNode
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //pointing to the next node
    public HeroNode2 pre; //pointing to the previous node

    //constructor
    public HeroNode2(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //we reconstruct the toString method
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''+
                '}';
    }

}


