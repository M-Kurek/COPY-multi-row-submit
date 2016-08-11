
#Spring MVC: Multiple Row Form Submit using List of Beans

BY VIRAL PATEL · DECEMBER 1, 2011

http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/


Related: [Spring 3 MVC Tutorial Series (Must Read)](http://viralpatel.net/blogs/tutorial-spring-3-mvc-introduction-spring-mvc-framework/)

[...]
note how we defined textboxes name. It is in form contacts[i].a. Thus Spring knows that we want to display the List item with index i and its attribute a.

    contacts[${status.index}].firstname will generate each rows as follows:


    contacts[0].firstname // mapped to first item in contacts list
    contacts[1].firstname // mapped to second item in contacts list
    contacts[2].firstname // mapped to third item in contacts list

[...]
##Spring 3 MVC and path attribute and square bracket

One thing here is worth noting that we haven’t used Spring’s tag to render textboxes. This is because Spring MVC 3 has a unique way of handling path attribute for tag. If we define the textbox as follows:

    <form:input path="contacts[${status.index}].firstname" />

Then instead of converting it to following HTML code:

    <input name="contacts[0].firstname" />
    <input name="contacts[1].firstname" />
    <input name="contacts[2].firstname" />

It converts it into following:

    <input name="contacts0.firstname" />
    <input name="contacts1.firstname" />
    <input name="contacts2.firstname" />

[...]

It seems w3c has later changed the HTML specification and removed [ ] from html input name.
Read the specification http://www.w3.org/TR/html4/types.html#type-name. It clearly says that:

>ID and NAME tokens must begin with a letter ([A-Za-z]) and may be followed by any number of letters, digits ([0-9]), hyphens (“-“), underscores (“_”), colons (“:”), and periods (“.”).

Thus, square brackets aren’t allowed in name attribute! And thus Spring 3 onwards this was implemented.

**So far I haven’t got any workaround to use springs \<form:input /> tag instead of plain html    \<input /> to render and fetch data from multiple rows.**

[...]


