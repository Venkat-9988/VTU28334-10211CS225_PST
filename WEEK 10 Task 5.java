import java.util.*;

class Node {
    String song;
    Node next;

    Node(String song) {
        this.song = song;
        this.next = null;
    }
}

class Playlist {
    Node head;

    // Add song
    void addSong(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // Remove song
    void removeSong(String song) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (head.song.equals(song)) {
            head = head.next;
            System.out.println(song + " removed.");
            return;
        }

        Node temp = head;

        while (temp.next != null && !temp.next.song.equals(song)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(song + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println(song + " removed.");
        }
    }

    // Display playlist
    void display() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node temp = head;

        System.out.println("Playlist:");
        while (temp != null) {
            System.out.println(temp.song);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Playlist playlist = new Playlist();

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song: ");
            playlist.addSong(sc.nextLine());
        }

        playlist.display();

        System.out.print("\nEnter song to remove: ");
        String song = sc.nextLine();

        playlist.removeSong(song);

        System.out.println();
        playlist.display();
    }
}
