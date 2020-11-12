package letscode.sarafan.controller;

import letscode.sarafan.domain.Message;
import letscode.sarafan.exceptions.NotFoundException;
import letscode.sarafan.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    /*
        private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {
            {
                add(new HashMap<String, String>() {{
                    put("id", "1");
                    put("text", "First message");
                }});
                add(new HashMap<String, String>() {{
                    put("id", "2");
                    put("text", "Second message");
                }});
                add(new HashMap<String, String>() {{
                    put("id", "3");
                    put("text", "Third message");
                }});
            }
        };

    @GetMapping
    public List<Map<String, String>> list() {
        return messages;
    }

        @GetMapping("{id}")
    public Map<String, String> getMessage(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));
        messages.add(message);

        return message;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {

        Map<String, String> messageFromDb = getMessage(id);
        messageFromDb.putAll(message);
        messageFromDb.put("id", id);
        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> message = getMessage(id);
        messages.remove(message);
    }
*/
    @GetMapping
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("/{id}")
    public Message getOne(@PathVariable("id") Message message) {
        if (message == null) {
            throw new IllegalArgumentException("no message with this id");
        }
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        return messageRepo.save(message);
    }

    @PutMapping("/{id}")
    public Message update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        return messageRepo.save(messageFromDb);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }
}