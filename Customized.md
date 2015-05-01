## How to create a customized model component for a view specific component ##

# Introduction #
MVP4j provides a set of  predefined model components, this model component represents the rules that administer the bind between the view and the model entities. However, some programmers may need to define or modify those bind rules for a special need, to make it possible, The interface MVPBinding allow the programmer,through the method **setComponentModel**, to assign a customized model component to a specific view component.
