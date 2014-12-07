package sem1.prac.linledlist;

import java.awt.HeadlessException;
import java.awt.dnd.DnDConstants;
import java.beans.FeatureDescriptor;

public class DLinkedList {

	DNode first;
	DNode last;

	DLinkedList() {

		first = null;
		last = null;
	}

	void insertFirst(int data) {

		DNode newNode = new DNode(data);

		if (first == null && last == null) {

			newNode.prev = first;
			newNode.next = last;

			first = newNode;
			last = newNode;

		} else {

			newNode.next = first;
			newNode.prev = first.prev;
			first.prev = newNode;
			first = newNode;

		}

	}

	void insertLast(int data) {

		DNode newNode = new DNode(data);

		if (first == null && last == null) {

			newNode.prev = first;
			newNode.next = last;

			first = newNode;
			last = newNode;

		} else {

			newNode.next = last.next;
			last.next = newNode;
			newNode.prev = last;
			last = newNode;

		}

	}

	void display() {

		DNode refNodeFirst = first;
		DNode refNodeLast = last;
		while (refNodeFirst != null) {

			System.out.print(refNodeFirst.data);

			refNodeFirst = refNodeFirst.next;

		}
		System.out.println("\nLast");
		while (refNodeLast != null) {

			System.out.print(refNodeLast.data);

			refNodeLast = refNodeLast.prev;

		}
		System.out.println("\n");
	}

	void insertAfter(int data, int afterData) {

		DNode newNode = new DNode(data);

		DNode refNode = first;

		while (refNode != null) {

			if (refNode.data == afterData) {

				if (refNode == last) {
					newNode.next = last.next;
					last.next = newNode;
					newNode.prev = last;
					last = newNode;
				} else {
					newNode.next = refNode.next;
					refNode.next = newNode;
					newNode.prev = refNode;
					newNode.next.prev = newNode;
				}
				break;
			}

			refNode = refNode.next;
		}

	}

	void insertBefore(int data, int beforeData) {

		DNode newNode = new DNode(data);

		DNode refNode = first;

		while (refNode != null) {

			if (refNode.data == beforeData) {

				if (refNode == first) {
					newNode.next = first;
					newNode.prev = first.prev;
					first.prev = newNode;
					first = newNode;
				} else {

					newNode.prev = refNode.prev;
					refNode.prev = newNode;
					newNode.prev.next = newNode;
					newNode.next = refNode;
				}
				break;
			}

			refNode = refNode.next;
		}

	}

	void deleteFirst() {

		if (first != last && (first != null && last != null)) {

			first.next.prev = first.prev;
			first = first.next;

		} else {
			first = null;
			last = null;
		}

	}

	void deleteLast() {

		if (first != last && (first != null && last != null)) {

			last.prev.next = last.next;
			last = last.prev;

		} else {
			first = null;
			last = null;
		}

	}

	void deleteBefore(int beforeData) {

		DNode refNode = first;

		while (refNode != null) {

			if (refNode.data == beforeData) {
				break;
			} else if (refNode.next.data == beforeData && refNode.prev != null) {

				refNode.prev.next = refNode.next;
				refNode.next.prev = refNode.prev;
				break;
			} else if (refNode.prev == null) {

				refNode.next.prev = refNode.prev;
				first = refNode.next;
				break;
			}

			refNode = refNode.next;
		}

	}

	void deleteAfter(int afterData) {

		DNode refNode = first;

		while (refNode != null) {
			if (refNode.data == afterData && refNode.next == null) {
				break;
			} else if (refNode.data == afterData && refNode.next.next != null) {

				refNode.next = refNode.next.next;
				refNode.next.prev = refNode;
				break;
			} else if (refNode.data == afterData && refNode.next.next == null) {
				refNode.next = refNode.next.next;
				break;
			}

			refNode = refNode.next;
		}

	}

	void delete(int data) {

		DNode refNode = first;

		while (refNode != null) {

			if (refNode.data == data && (refNode.next != null && refNode.prev != null)) {

				refNode.prev.next = refNode.next;
				refNode.next.prev = refNode.prev;
				break;
			} else if (refNode.data == data && refNode.next == null) {

				refNode.prev.next = refNode.next;
				last = refNode.prev;
				break;
			} else if (refNode.data == data && refNode.prev == null) {

				refNode.next.prev = refNode.prev;
				first = refNode.next;
				break;
			}

			refNode = refNode.next;
		}

	}

	void reverse() {

		DNode refFirst = first;
		last = refFirst;

		if (first == null && last == null) {
			return;
		} else {

			while (refFirst != null) {

				first = refFirst;

				DNode temp = refFirst.next;
				refFirst.next = refFirst.prev;
				refFirst.prev = temp;
				refFirst = refFirst.prev;

			}
		}

	}
}
