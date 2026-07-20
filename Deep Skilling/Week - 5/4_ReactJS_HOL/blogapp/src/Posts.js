import React from 'react';
import Post from './Post';

class Posts extends React.Component {
constructor(props) {
super(props);
this.state = {
posts: [],
hasError: false
};
}

loadPosts = () => {
fetch('https://jsonplaceholder.typicode.com/posts')
.then(res => res.json())
.then(data => this.setState({ posts: data }))
.catch(error => {
this.setState({ hasError: true });
alert("Error fetching posts: " + error);
});
};

componentDidMount() {
this.loadPosts();
}

componentDidCatch(error, info) {
this.setState({ hasError: true });
alert("Component Error: " + error);
}

render() {
if (this.state.hasError) {
return <h1>Something went wrong.</h1>;
}
return (
<div>
{this.state.posts.map(post => (
<Post key={post.id} title={post.title} body={post.body} />
))}
</div>
);
}
}

export default Posts;