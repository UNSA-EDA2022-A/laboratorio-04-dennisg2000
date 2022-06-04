package com.example.project;

public class SinglyLinkedList<T> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }
    public boolean esIgual(T a,T b) {//se comparan los valores
    	return (a == b);
    }

    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    public void deleteDuplicates() {
        int[] posiciones = new int[size];
    	for(int a=0;a<size;a++)
    		posiciones[a]=0;
    	int pos=0;
    	int pos2=0;
    	Node<T> cur = first;
        while (cur.getNext() != null) {//se compara el primer elemento con los demas
        	Node<T> cur2 = cur.getNext();
        	pos2=pos;
        	while(cur2!= null) {
        		if(esIgual(cur2.getValue(),cur.getValue())) {
        			posiciones[pos2]=1;     //se guarda las posiciones de los elementos duplicados
        		}
        		cur2 = cur2.getNext();
        		pos2++;
        	}
        	cur = cur.getNext();
        	pos++;
        	
        }
        int tam=size;
        int despl=1;
        for (int i = 0; i < tam; i++) {
            if(posiciones[i]==1) {
            	deleteNth(i+despl); //se eliminan los elementos duplicados segun las posiciones guardadas
            	despl-=1;
            }
            
        }  
        	

    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position) {
        if (isEmpty())
            return;
    	if (position>size) {
    		System.out.println("Fuera de rango.");
    		return;
    	}
    	if(position==0) {
    		addFirst(data);
    		return ;
    	}
    	else {
           
            Node<T> cur = first;
            for (int i = 0; i < position-1; i++)//se avanza hasta el elmento en cuestion y se acualizan las direcciones
                cur = cur.getNext();
            Node<T> newNode = new Node<T>(data, null);
            newNode.setNext(cur.getNext());
            cur.setNext(newNode);
        }
        size++;
    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
        if (isEmpty())
            return;
    	if (position>size) {
    		System.out.println("Fuera de rango.");
    		return;
    	}
    	if(position==0) {
    		removeFirst();
    		return ;
    	}
    	else {
            
            Node<T> cur = first;
            for (int i = 0; i < position-1; i++)//se actualiza la direccion del elemento anterior al que va a ser eliminado al siguiente de este
                cur = cur.getNext();
            
            cur.setNext(cur.getNext().getNext());
        }
        size--;

    }

    public static void main(final String[] args) {

        // testExercicio1();
        // testExercicio2();
        testExercicio3();       

    }

    public static void testExercicio1(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(47);
        list.addLast(89);
        list.addLast(56);
        list.addLast(89);
        list.addLast(56);

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.insertNth('c', 2);

        System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.deleteNth(2);

        System.out.println(list);
    }

}
