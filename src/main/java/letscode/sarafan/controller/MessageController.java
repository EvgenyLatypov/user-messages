package letscode.sarafan.controller;

import letscode.sarafan.domain.Message;
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