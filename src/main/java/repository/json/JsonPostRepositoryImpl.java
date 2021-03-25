package repository.json;

import Model.Post;
import repository.PostRepository;
import repository.json.io.read.FileReaderPost;
import repository.json.io.write.FileWriterPost;
import repository.json.io.read.Reader;
import repository.json.io.write.Writer;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class JsonPostRepositoryImpl implements PostRepository {

    private File file = new File("posts.json");
    private Reader reader = new FileReaderPost();
    private Writer writer = new FileWriterPost();


    @Override
    public Post getByld(Long id) {
        List<Post> posts = reader.read(file);

        for(Post post: posts){
            if(post.getId() == id){
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> getAll() {

        List<Post> posts = reader.read(file);
        return posts;
    }

    @Override
    public Post save(Post post) {

        long newPostId;

        List<Post> posts = reader.read(file);

        if(posts.size() == 0){
            newPostId = 1;
        } else {
            newPostId = posts.get(posts.size() - 1).getId() + 1;
        }
        post.setId(newPostId);
        posts.add(post);

        writer.write(posts, file);

        return post;
    }

    @Override
    public Post update(Post post) {
        List<Post> posts = reader.read(file);

        List<Post> postUpdate = posts.stream().map(n -> {if(n.getId() == post.getId()){
            n.setContent(post.getContent());
            n.setCreated(post.getCreated());
            n.setUpdated(post.getUpdated());}
            return n;
        }).collect(Collectors.toList());
        Post newPost = postUpdate.stream().filter(n -> n.getId() == post.getId()).findFirst().
                orElse(null);

        writer.write(postUpdate, file);

        return newPost;
    }

    @Override
    public void deleteByld(Long id) {
        List<Post> posts = reader.read(file);

        List<Post> postUpdate = posts.stream().map(n -> {if(n.getId() == id){
            posts.remove(n);}
            return n;}).collect(Collectors.toList());

        writer.write(postUpdate, file);
    }
}
