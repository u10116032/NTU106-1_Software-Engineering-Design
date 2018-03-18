Strategy:
	Define a family of algorithms, encapsulate each one, and make them interchangeable.
	Strategy lets the algorithms vary independently from clients that use it.

Observer:
	Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

Decorator:
	Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
	Extending responsibilities via subclassing forces developers to consider that a new class would have to be made for every possible combination. By contrast, decorators are objects, created at runtime, and can be combined on a per-use basis.

Factory method:
	Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

Abstract Factory:
	Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

Builder:
	Separate the construction of a complex object from its representation so that the same construction process can create different representations.

Singleton:
	Ensure a class only has one instance, and provide a global point of access to it.

Vistor:
	Represent an operation to be performed on the elements of an object structure.
	Visitor lets you define a new operation without changing the classes of the elements on which it operates.

Iterator:
	Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

Composite:
	Compose objects into tree structures to represent part- whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

Bridge:
	Decouple an abstraction from its implementation so that the two can vary independently.